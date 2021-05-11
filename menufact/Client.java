package menufact;

public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * @param idClient
     * @param nom
     * @param numeroCarteCredit
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */