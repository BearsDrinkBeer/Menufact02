package inventaire;

import ingredients.IngredientAuMenu;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventaire {
    private static IngredientInventaire inventaire;
    private Map<IngredientAuMenu,Integer> ingredients = new HashMap<>();

    private IngredientInventaire() {
    }

    /**
     * @return
     */
    public static IngredientInventaire getInventaire() {
        if (inventaire == null)
            inventaire = new IngredientInventaire();
        return inventaire;
    }

    /**
     * @param ingredient
     * @param quantity
     */
    public void addIngredient(IngredientAuMenu ingredient, Integer quantity) {
        this.ingredients.put(ingredient,quantity);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        String text = "";
        for (Map.Entry<IngredientAuMenu, Integer> entry: ingredients.entrySet()) {
            text += (entry.getKey() + ", quantite : " + entry.getValue()) +
            "\n";
        }
        return text;
    }

    public Map<IngredientAuMenu, Integer> getIngredients() { return ingredients; }
}
