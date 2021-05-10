package testsunitaires;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IngredientAuMenu;
import inventaire.IngredientInventaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientInventaireTest {

    private IngredientInventaire inventaire;
    private Map<Ingredient,Integer> ingredient = new HashMap<>();
    private IngredientAuMenu epice;
    private void assertArrayEquals(IngredientInventaire inventaire, IngredientInventaire inventaire1) {
    }
    @BeforeEach
    public void setUp() throws Exception {
        inventaire = IngredientInventaire.getInventaire();
        epice = new Epice();
        ingredient.put(epice, 2);
    }

    @Test
    void getInventaire() {
        assertArrayEquals(inventaire, IngredientInventaire.getInventaire());
    }

    @Test
    void addIngredient() {
        inventaire.addIngredient(epice, 2);
        assertEquals(ingredient, inventaire.getIngredients());
    }
}