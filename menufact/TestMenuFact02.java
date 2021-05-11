package menufact;

import ingredients.Fruit;
import ingredients.Laitier;
import ingredients.bridge.Liquide;
import ingredients.bridge.Solide;
import ingredients.factory.FactoryFruit;
import ingredients.factory.FactoryLaitier;
import inventaire.IngredientInventaire;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;

import java.util.ArrayList;

public class TestMenuFact02 {

    public static void main(String[] args) throws FactureException {
        final boolean trace = true;

        TestMenuFact02 t = new TestMenuFact02();
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
        inventaire1.addIngredient(pomme,100);
        inventaire1.addIngredient(lait, 100);

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
            platsEnfant.get(i).setIngredients(pomme, 4);
            platsEnfant.get(i).setIngredients(lait, 4);
        }

        //Plat au menu
        FactoryPlatAuMenu factoryPlatAuMenu = new FactoryPlatAuMenu();
        ArrayList<PlatAuMenu> platsAuMenu = new ArrayList<>();

        for (int i = 0; i < 2; i++){
            platsAuMenu.add(factoryPlatAuMenu.createPlat());
            platsAuMenu.get(i).setCode(i + 20);
            platsAuMenu.get(i).setDescription("PlatAuMenu" + i);
            platsAuMenu.get(i).setPrice(i + 1);
            platsAuMenu.get(i).setIngredients(pomme, 4);
            platsAuMenu.get(i).setIngredients(lait, 4);
        }

        //Menu
        Menu menu = Menu.getMenu();
        menu.setDescription("Menu with Plats");

        //Facture
        Facture facture = new Facture("Ma facture");

        //Client
        Client client = new Client(1,"Mr Client","1234567890");

        //Tests
        t.test1_AffichePlatsAuMenu(trace, platsAuMenu);
        t. test2_AffichePlatsSante(trace, platsSante);
        t.test4_AjoutPlatsAuMenu(trace, platsAuMenu, platsSante, platsEnfant, menu);

        try {
            t.test5_DeplacementMenuAvancer(menu);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(menu);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test7_CreerFacture(facture, menu);
        } catch (FactureException e) {
            System.out.println(e.getMessage());
        }

        t.test8_AjouterClientFacture(facture, client);

        try {
            t.test9_AjouterPlatsFacture(facture, menu,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        } catch (MenuException me)
        {
            System.out.println(me);
        }

        t.test10_PayerFacture(facture);

        try {
            t.test9_AjouterPlatsFacture(facture, menu,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        try {
            facture.ouvrir();
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("FIN DE TOUS LES TESTS...");

        System.out.println(facture.genererFacture());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, ArrayList<PlatAuMenu> plats){
        System.out.println("=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.println(plats);
        }
    }


   private void test2_AffichePlatsSante(boolean trace, ArrayList<PlatSante> plats)
    {
        System.out.println("=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.println(plats);
        }
    }


    private static void test3_AjoutMenu(boolean trace, Menu...menus)
    {

        System.out.println("=== test3_AjoutMenu");

        if(trace) {
            for(Menu menu : menus) {
                System.out.println(menu);
            }
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, ArrayList<PlatAuMenu> platAuMenus, ArrayList<PlatSante> platSantes, ArrayList<PlatEnfant> platEnfants, Menu menu)
    {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        for (PlatAuMenu plat : platAuMenus) {
            menu.ajoute(plat);
        }

        for (PlatSante plat : platSantes) {
            menu.ajoute(plat);
        }

        for (PlatEnfant plat : platEnfants) {
            menu.ajoute(plat);
        }

        System.out.println("=== Creation du menu 2");
        Menu menu2 = Menu.getMenu();

        if(trace) {
            System.out.println(menu);
            System.out.println(menu2);
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
            m1.positionSuivante();
            System.out.println("1." + m1.platCourant());
            m1.positionSuivante();
            System.out.println("2." + m1.platCourant());
            m1.positionSuivante();
            System.out.println("3." + m1.platCourant());
            m1.positionSuivante();
            System.out.println("4." + m1.platCourant());
            m1.positionSuivante();
            System.out.println("5." + m1.platCourant());
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
            m1.positionPrecedente();
            System.out.println("2." + m1.platCourant());
            m1.positionPrecedente();
            System.out.println("1." + m1.platCourant());
            m1.positionPrecedente();
            System.out.println("0." + m1.platCourant());
            m1.positionPrecedente();
            System.out.println("-1." + m1.platCourant());
            m1.positionPrecedente();
            System.out.println("-2." + m1.platCourant());
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException
    {
        System.out.println("\n===test7_CreerFacture");

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

    private void test9_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException,FactureException
    {
        System.out.println("===test9_AjouterPlatsFacture");

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

    private void test10_PayerFacture(Facture f1)
    {
        System.out.println("===test10_PayerFacture");

        System.out.println("\nAvant payer la facture");
        System.out.println(f1);
        f1.payer();
        System.out.println("\nApres avoir paye la facture");
        System.out.println(f1);
    }
}
