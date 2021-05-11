package testsunitaires;

import menufact.factory.FactoryPlatSante;
import menufact.factory.PlatSante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatSanteTest {
    private PlatSante platSante;

    @BeforeEach
    public void setup(){
        FactoryPlatSante factoryPlatSante = new FactoryPlatSante();
        platSante = factoryPlatSante.createPlat();
        platSante.setKcal(10);
        platSante.setChol(20);
        platSante.setGras(30);
    }

    @Test
    void getKcal() {
        Assertions.assertEquals(10, platSante.getKcal());
    }

    @Test
    void setKcal() {
        platSante.setKcal(40);
        Assertions.assertEquals(40, platSante.getKcal());
    }

    @Test
    void getChol() {
        Assertions.assertEquals(20, platSante.getChol());
    }

    @Test
    void setChol() {
        platSante.setChol(50);
        Assertions.assertEquals(50, platSante.getChol());
    }

    @Test
    void getGras() {
        Assertions.assertEquals(30, platSante.getGras());
    }

    @Test
    void setGras() {
        platSante.setGras(60);
        Assertions.assertEquals(60, platSante.getGras());
    }
}