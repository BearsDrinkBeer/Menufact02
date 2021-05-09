package menufact;

import ingredients.Bridge.Liquide;
import ingredients.Bridge.Solide;
import ingredients.Factory.FactoryFruit;
import ingredients.Factory.FactoryLaitier;
import ingredients.Fruit;
import inventaire.IngredientInventaire;
import ingredients.Laitier;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;

import java.util.ArrayList;

public class TestMenuFact02 {

    public static void main(String[] args) throws FactureException {
        boolean trace = true;

        //Les ingredients
        System.out.println("ajout des ingredients...\n");

        //Lait
        FactoryLaitier factoryLaitier = new FactoryLaitier();
        Laitier lait = factoryLaitier.createIngredients();
        lait.setNom("Lait");
        lait.setDescription("poche de lait");
        lait.setEtat(new Liquide());

        //Pomme
        FactoryFruit factoryFruit = new FactoryFruit();
        Fruit pomme = factoryFruit.createIngredients();
        pomme.setNom("Pomme");
        pomme.setDescription("poche de pommes");
        pomme.setEtat(new Solide());

        //L'inventaire
        System.out.println("======INVENTAIRE======");
        IngredientInventaire inventaire1 = IngredientInventaire.getInventaire();
        inventaire1.addIngredient(pomme,4);
        inventaire1.addIngredient(lait, 4);

        System.out.println(inventaire1);

        //Les plats
        System.out.println("ajout des plats...\n");

        //Plat sante
        FactoryPlatSante factoryPlatSante = new FactoryPlatSante();
        ArrayList<PlatSante> platsSante = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            platsSante.add(factoryPlatSante.createPlat());
            platsSante.get(i).setCode(i);
            platsSante.get(i).setDescription("PlatSante" + i);
            platsSante.get(i).setPrice(i);
            platsSante.get(i).setChol(i * 10);
            platsSante.get(i).setGras(i * 10);
            platsSante.get(i).setKcal(i * 10 + 1);
            platsSante.get(i).setIngredients(pomme, 4);
            platsSante.get(i).setIngredients(lait, 4);
        }

        //Plat enfant
        FactoryPlatEnfant factoryPlatEnfant = new FactoryPlatEnfant();
        ArrayList<PlatEnfant> platsEnfant = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            platsEnfant.add(factoryPlatEnfant.createPlat());
            platsEnfant.get(i).setCode(i + 10);
            platsEnfant.get(i).setDescription("PlatEnfant" + i);
            platsEnfant.get(i).setPrice(i + 1);
            platsEnfant.get(i).setProportion(i + 0.2);
        }

        //Plat au menu
        FactoryPlatAuMenu factoryPlatAuMenu = new FactoryPlatAuMenu();
        ArrayList<PlatAuMenu> platsAuMenu = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            platsAuMenu.add(factoryPlatAuMenu.createPlat());
            platsAuMenu.get(i).setCode(i + 20);
            platsAuMenu.get(i).setDescription("PlatAuMenu" + i);
            platsAuMenu.get(i).setPrice(i + 1);
        }

        //Menu
        System.out.println("======MENU======");
        Menu menu = Menu.getMenu();
        menu.setDescription("Menu with Plats");

        for(PlatSante plat : platsSante){
            menu.ajoute(plat);
        }

        for(PlatEnfant plat : platsEnfant){
            menu.ajoute(plat);
        }

        for(PlatAuMenu plat : platsAuMenu){
            menu.ajoute(plat);
        }

        System.out.println(menu);
        System.out.println("Test un item: " + menu.getPlatAuMenu(2));

        //Plat choisi
        System.out.println("======PLATCHOISI======");

        ArrayList<PlatChoisi> platsChoisis = new ArrayList<>();

        for(PlatSante plat : platsSante){
            platsChoisis.add(new PlatChoisi(plat, 1));
        }

        System.out.println(platsChoisis);

        //Facture
        System.out.println("======FACTURE======");
        Facture facture = new Facture("Ma facture");

        Client client = new Client(1,"Mr Client","1234567890");

        facture.associerClient(client);

        for(PlatChoisi plat : platsChoisis){
            facture.ajoutePlat(plat);
        }

        System.out.println(platsChoisis);

        System.out.println("======FACTURE======");
        System.out.println(facture.genererFacture());



//        t.test1_AffichePlatsAuMenu(trace, p1,p2,p3,p4,p5);
//        t. test2_AffichePlatsSante(trace, ps1,ps2,ps3,ps4,ps5);
//
//        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);
//
//
//        try {
//            t.test5_DeplacementMenuAvancer(m1);
//        } catch (MenuException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            t.test6_DeplacementMenuReculer(m1);
//        } catch (MenuException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            t.test7_CreerFacture(f1, m1);
//        } catch (FactureException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        t.test8_AjouterClientFacture(f1, c1);
//
//        try {
//            t.test8_AjouterPlatsFacture(f1, m1,1);
//        } catch (FactureException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//        catch (MenuException me)
//        {
//            System.out.println(me);
//        }
//
//        t.test9_PayerFacture(f1);
//
//        try {
//            t.test8_AjouterPlatsFacture(f1, m1,1);
//        } catch (FactureException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//        catch (MenuException me)
//        {
//            System.out.println(me);
//        }
//
//        try {
//            f1.ouvrir();
//        } catch (FactureException fe)
//        {
//            System.out.println(fe.getMessage());
//        }
//
//
//
//
//
//
//        System.out.println("FIN DE TOUS LES TESTS...");
//
//        System.out.println(f1.genererFacture());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
                                                 PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5)
    {
        System.out.println("=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }


   private void test2_AffichePlatsSante(boolean trace, PlatSante ps1, PlatSante ps2,
                                               PlatSante ps3, PlatSante ps4, PlatSante ps5)
    {
        System.out.println("=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }


    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
    {

        System.out.println("=== test3_AjoutMenu");

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1,
                                        PlatAuMenu p1, PlatAuMenu p2,
                                        PlatSante ps1, PlatSante ps2,
                                        Menu m2,
                                        PlatAuMenu p3, PlatAuMenu p4,
                                        PlatSante ps3, PlatSante ps4)
    {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);


        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException
    {
        System.out.println("=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        }
        catch (MenuException me)
        {
                throw me;
        }
    }


    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException
    {
        System.out.println("===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException
    {
        System.out.println("===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }


    private void test8_AjouterClientFacture(Facture f1,Client c1) {
        System.out.println("===test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }
    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException,FactureException
    {
        System.out.println("===test8_AjouterPlatsFacture");

        try{
            for (int i=0; i< pos; i++)
                m1.positionSuivante();
        }
        catch (MenuException me)
        {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1)
    {
        System.out.println("===test9_PayerFacture");

        System.out.println("Avant payer la facture");
        System.out.println(f1);
        f1.payer();
        System.out.println("Apres avoir paye la facture");
        System.out.println(f1);
    }
}
