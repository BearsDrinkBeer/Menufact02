package testsunitaires;

import ingredients.Ingredient;
import ingredients.Laitier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    public void setUp() throws Exception {
        ingredient = new Laitier();
    }

    @Test
    void setNom() {
        ingredient.setNom("Allo");
        assertEquals("Allo", ingredient.getNom());
    }

    @Test
    void setDescription() {
        ingredient.setDescription("Allo");
        assertEquals("Allo", ingredient.getDescription());
    }

    @Test
    void getEtat() {

    }

    @Test
    void setEtat() {
    }

    @Test
    void getType() {
    }

    @Test
    void setType() {
    }

    @Test
    void testToString() {
    }
}