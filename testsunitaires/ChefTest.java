package testsunitaires;

import menufact.Client;
import menufact.observer.facture.Facture;
import menufact.observer.facture.exceptions.FactureException;
import menufact.factory.PlatAuMenu;
import menufact.state.PlatChoisi;
import menufact.state.Termine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChefTest {

    PlatChoisi plat;
    Facture facture;

    @BeforeEach
    public void setup(){
        facture = new Facture("New Facture");
        facture.associerClient(new Client(1, "MrPatate", "1234"));
        plat = new PlatChoisi(new PlatAuMenu(), 2);
    }

    @Test
    void update() throws FactureException {
        facture.ajoutePlat(plat);
        Assertions.assertTrue(plat.getState() instanceof Termine);
    }
}