package testsunitaires;

import ingredients.bridge.Liquide;
import ingredients.factory.Ingredient;
import ingredients.factory.Laitier;
import ingredients.factory.TypeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientAuMenuTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setUp() throws Exception {
        ingredient = new Laitier();
    }

    @Test
    void setNom() {
        ingredient.setNom("Lait");
        assertEquals("Lait", ingredient.getNom());
    }

    @Test
    void setDescription() {
        ingredient.setDescription("Poche de lait");
        assertEquals("Poche de lait", ingredient.getDescription());
    }

    @Test
    void setEtat() {
        ingredient.setEtat(new Liquide());
        assertEquals("ml", ingredient.getEtat().getUnit());
    }
    @Test
    void setType() {
        ingredient.setType(TypeIngredient.LAITIER);
        assertEquals(TypeIngredient.LAITIER, ingredient.getType());
    }
}