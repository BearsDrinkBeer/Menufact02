package testsunitaires;

import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.FactureEtat;
import menufact.facture.exceptions.FactureException;
import menufact.plats.FactoryPlatAuMenu;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactureTest {
    private PlatChoisi platChoisi;
    private Client client;
    private Facture facture;

    @BeforeEach
    public void setup() throws FactureException {
        FactoryPlatAuMenu factoryPlatAuMenu = new FactoryPlatAuMenu();
        PlatAuMenu platAuMenu = new PlatAuMenu();
        platAuMenu.setPrice(10);
        facture = new Facture("La facture a Manon");
        client = new Client(1, "Manon", "1234");
        platChoisi = new PlatChoisi(platAuMenu, 2);
        facture.ajoutePlat(platChoisi);
    }

    @Test
    void associerClient() {
        facture.associerClient(client);
        Assertions.assertEquals(client, facture.getClientFacture());
    }

    @Test
    void sousTotal() {
        Assertions.assertEquals(20, facture.sousTotal());
    }

    @Test
    void total() {
        Assertions.assertEquals(22.995, facture.total());
    }

    @Test
    void payer() {
        facture.payer();
        Assertions.assertEquals(FactureEtat.PAYEE, facture.getEtat());
    }

    @Test
    void fermer() {
        facture.fermer();
        Assertions.assertEquals(FactureEtat.FERMEE, facture.getEtat());
    }

    @Test
    void ouvrir() throws FactureException {
        facture.ouvrir();
        Assertions.assertEquals(FactureEtat.OUVERTE, facture.getEtat());
    }

    @Test
    void getEtat() {
        facture.setEtat(FactureEtat.PAYEE);
        Assertions.assertEquals(FactureEtat.PAYEE, facture.getEtat());
    }

    @Test
    void ajoutePlat() throws FactureException {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(), 2);
        facture.ajoutePlat(plat);
        Assertions.assertEquals(plat, facture.getPlat(facture.size() - 1));
    }
}