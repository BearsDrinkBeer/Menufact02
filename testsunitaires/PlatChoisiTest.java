package testsunitaires;

import menufact.plats.FactoryPlatAuMenu;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.state.Commande;
import menufact.state.Termine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatChoisiTest {
    private FactoryPlatAuMenu factoryPlatAuMenu;
    private PlatAuMenu platAuMenu;
    private PlatChoisi platChoisi;

    @BeforeEach
    public void setup(){
        factoryPlatAuMenu = new FactoryPlatAuMenu();
        platAuMenu = factoryPlatAuMenu.createPlat();
        platChoisi = new PlatChoisi(platAuMenu, 2);
    }

    @Test
    void getQuantite() {
        Assertions.assertEquals(2, platChoisi.getQuantite());
    }

    @Test
    void setQuantite() {
        platChoisi.setQuantite(5);
        Assertions.assertEquals(5, platChoisi.getQuantite());
    }

    @Test
    void getPlat() {
        Assertions.assertEquals(platAuMenu, platChoisi.getPlat());
    }

    @Test
    void getState() {
        Assertions.assertTrue(platChoisi.getState() instanceof Commande);
    }

    @Test
    void setState() {
        platChoisi.setState(new Termine(platChoisi));
        Assertions.assertTrue(platChoisi.getState() instanceof Termine);
    }
}