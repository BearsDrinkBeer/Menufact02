package ingredients.singleton;

import ingredients.factory.IngredientAuMenu;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventaire {
    private static IngredientInventaire inventaire;
    private Map<IngredientAuMenu,Integer> ingredients = new HashMap<>();

    private IngredientInventaire() {
    }

    /**
     * @return une instance de l'ingredients.inventaire (toujours la même)
     */
    public static IngredientInventaire getInventaire() {
        if (inventaire == null)
            inventaire = new IngredientInventaire();
        return inventaire;
    }

    /**
     * @param ingredient est l'ingredient a ajoute
     * @param quantity est la quantite de l'ingredient ajoute
     */
    public void addIngredient(IngredientAuMenu ingredient, Integer quantity) {
        this.ingredients.put(ingredient,quantity);
    }

    /**
     * @return l'ingredients.inventaire des ingredients et la quantite de chacun
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
