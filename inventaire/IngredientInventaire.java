package inventaire;

import ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventaire {
    private static IngredientInventaire inventaire;
    private Map<Ingredient,Integer> ingredients = new HashMap<>();

    private IngredientInventaire() {
    }

    public static IngredientInventaire getInventaire() {
        if (inventaire == null)
            inventaire = new IngredientInventaire();
        return inventaire;
    }

    public void addIngredient(Ingredient ingredient, Integer quantity) {
        this.ingredients.put(ingredient,quantity);
    }

    @Override
    public String toString() {
        String text = "";
        for (Map.Entry<Ingredient, Integer> entry: ingredients.entrySet()) {
            text += (entry.getKey() + ", quantite : " + entry.getValue()) +
            "\n";
        }
        return text;
    }

    public Map<Ingredient, Integer> getIngredients() { return ingredients; }
}
