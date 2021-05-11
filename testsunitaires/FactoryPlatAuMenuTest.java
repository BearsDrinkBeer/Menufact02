package testsunitaires;

import menufact.factory.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactoryPlatAuMenuTest {
    private FactoryPlatAuMenu factoryPlatAuMenu;
    private FactoryPlatSante factoryPlatSante;
    private FactoryPlatEnfant factoryPlatEnfant;


    @BeforeEach
    public void setup(){
        factoryPlatAuMenu = new FactoryPlatAuMenu();
        factoryPlatSante = new FactoryPlatSante();
        factoryPlatEnfant = new FactoryPlatEnfant();
    }

    @Test
    void createPlatAuMenu() {
        Assertions.assertTrue(factoryPlatAuMenu.createPlat() instanceof PlatAuMenu);
    }

    @Test
    void createPlatSante() {
        Assertions.assertTrue(factoryPlatSante.createPlat() instanceof PlatSante);
    }

    @Test
    void createPlatEnfant() {
        Assertions.assertTrue(factoryPlatEnfant.createPlat() instanceof PlatEnfant);
    }
}