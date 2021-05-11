package testsunitaires;

import ingredients.bridge.Liquide;
import ingredients.factory.FactoryLaitier;
import ingredients.IngredientAuMenu;
import menufact.plats.FactoryPlatAuMenu;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PlatAuMenuTest {

    private PlatAuMenu platAuMenu;
    private IngredientAuMenu lait;
    private FactoryLaitier factoryLaitier;
    private Map<IngredientAuMenu, Integer> ingredients = new HashMap<>();

    @BeforeEach
    public void setup(){
        FactoryPlatAuMenu factoryPlatAuMenu = new FactoryPlatAuMenu();
        platAuMenu = factoryPlatAuMenu.createPlat();
        factoryLaitier = new FactoryLaitier();
        lait = factoryLaitier.createIngredients();
        lait.setNom("lait");
        lait.setDescription("poche de lait");
        lait.setEtat(new Liquide());
        platAuMenu.setCode(123);
        platAuMenu.setDescription("PlatAuMenu");
        platAuMenu.setPrice(21);
        platAuMenu.setIngredients(lait, 1);
        ingredients.put(lait, 1);
    }

    @Test
    void getIngredients() {
        Assertions.assertEquals(ingredients, platAuMenu.getIngredients());
    }

    @Test
    void setIngredients() {
        IngredientAuMenu yogourt = factoryLaitier.createIngredients();
        ingredients.put(yogourt, 2);
        platAuMenu.setIngredients(yogourt, 2);
        Assertions.assertEquals(ingredients, platAuMenu.getIngredients());
    }

    @Test
    void getCode() {
        Assertions.assertEquals(123, platAuMenu.getCode());
    }

    @Test
    void setCode() {
        platAuMenu.setCode(1234);
        Assertions.assertEquals(1234, platAuMenu.getCode());
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("PlatAuMenu", platAuMenu.getDescription());
    }

    @Test
    void setDescription() {
        platAuMenu.setDescription("PlatAuMenuModifie");
        Assertions.assertEquals("PlatAuMenuModifie", platAuMenu.getDescription());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(21, platAuMenu.getPrice());
    }

    @Test
    void setPrice() {
        platAuMenu.setPrice(32);
        Assertions.assertEquals(32, platAuMenu.getPrice());
    }
}