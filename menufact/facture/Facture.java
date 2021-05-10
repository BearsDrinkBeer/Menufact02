package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.observer.Chef;
import menufact.observer.EventManager;
import menufact.plats.PlatChoisi;
import menufact.state.Preparation;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;
    private EventManager event;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    public Client getClientFacture() {
        return this.client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrice();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer()
    {
        etat = FactureEtat.PAYEE;
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
        etat = FactureEtat.FERMEE;
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        if (etat == FactureEtat.PAYEE)
            throw new FactureException("La facture ne peut pas être reouverte.");
        else
            etat = FactureEtat.OUVERTE;
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    public void setEtat(FactureEtat etat) {
        this.etat = etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = FactureEtat.OUVERTE;
        courant = -1;
        this.description = description;
        this.event = new EventManager("addPlat");
        event.subscribe("addPlat", new Chef());
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        if (etat == FactureEtat.OUVERTE) {
            platchoisi.add(p);
            p.setState(new Preparation(p));
            event.notify("addPlat", p);
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     *
     * @param index
     * @return
     * @throws FactureException
     */
    public PlatChoisi getPlat(int index) throws FactureException
    {
        if (etat == FactureEtat.OUVERTE) {
            if(index >= platchoisi.size())
                throw new FactureException("Array index out of bound");
            return platchoisi.get(index);
        }
        else
            throw new FactureException("On peut voir un plat seulement sur une facture OUVERTE.");
    }

    /**
     *
     * @param index
     * @return
     * @throws FactureException
     */
    public PlatChoisi removePlat(int index) throws FactureException
    {
        if (etat == FactureEtat.OUVERTE) {
            if(index >= platchoisi.size())
                throw new FactureException("Array index out of bound");
            return platchoisi.remove(index);
        }
        else
            throw new FactureException("On peut voir un plat seulement sur une facture OUVERTE.");
    }

    public int size(){
        return platchoisi.size();
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date : '" + date + '\'' +
                ", description : '" + description + '\'' +
                ", etat : '" + etat + '\'' +
                ", platchoisi : '"  + platchoisi + '\'' +
                ", courant : '" + courant + '\'' +
                ", client : '" + client + '\'' +
                ", TPS : '" + TPS + '\'' +
                ", TVQ : '" + TVQ +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        if(etat == FactureEtat.OUVERTE) {
            int i = 1;


            factureGenere = "Facture generee.\n" +
                    "Date:" + date + "\n" +
                    "Description: " + description + "\n" +
                    "Client:" + client.getNom() + "\n" +
                    "Les plats commandes:" + "\n" + lesPlats;

            factureGenere += "Seq   Plat         Prix   Quantite\n";
            for (PlatChoisi plat : platchoisi) {
                factureGenere += i + "     " + plat.getPlat().getCode() + "  " + plat.getPlat().getPrice() + "      " + plat.getQuantite() + "\n";
                i++;
            }

            factureGenere += "          TPS:               " + tps() + "\n";
            factureGenere += "          TVQ:               " + tvq() + "\n";
            factureGenere += "          Le total est de:   " + total() + "\n";
        }
        return factureGenere;
    }
}
