package testsunitaires;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.state.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatePreparationTest {
    private Commande commande;
    private Servi servi;
    private Preparation preparation;
    private Impossible impossible;
    private Termine termine;

    @BeforeEach
    public void setup(){
         PlatChoisi platChoisi = new PlatChoisi(new PlatAuMenu(), 2);
         commande = new Commande(platChoisi);
         servi =  new Servi(platChoisi);
         preparation = new Preparation(platChoisi);
         impossible = new Impossible(platChoisi);
         termine = new Termine(platChoisi);
    }

    @Test
    void commande() {
        Assertions.assertTrue(commande instanceof Commande);
    }

    @Test
    void preparation() {
        Assertions.assertTrue(preparation instanceof Preparation);
    }

    @Test
    void termine() {
        Assertions.assertTrue(termine instanceof Termine);
    }

    @Test
    void servi() {
        Assertions.assertTrue(servi instanceof Servi);
    }

    @Test
    void impossible() {
        Assertions.assertTrue(impossible instanceof Impossible);
    }
}