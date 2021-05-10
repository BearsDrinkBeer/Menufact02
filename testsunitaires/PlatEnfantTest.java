package testsunitaires;

import menufact.plats.FactoryPlatEnfant;
import menufact.plats.PlatEnfant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatEnfantTest {
    private PlatEnfant platEnfant;

    @BeforeEach
    public void setup(){
        FactoryPlatEnfant factoryPlatEnfant = new FactoryPlatEnfant();
        platEnfant = factoryPlatEnfant.createPlat();
        platEnfant.setProportion(2);
    }

    @Test
    void getProportion() {
        Assertions.assertEquals(2, platEnfant.getProportion());
    }

    @Test
    void setProportion() {
        platEnfant.setProportion(3);
        Assertions.assertEquals(3, platEnfant.getProportion());
    }
}