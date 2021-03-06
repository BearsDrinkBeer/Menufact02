package menufact.plats;

import ingredients.factory.IngredientAuMenu;

import java.util.HashMap;
import java.util.Map;

public class PlatAuMenu implements Plat {
    private int code;
    private String description;
    private double price;
    private Map<IngredientAuMenu, Integer> ingredients = new HashMap<>();

    public PlatAuMenu(){}

    /**
     * @return le code, la description et le prix du plat.
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu : {" +
                "code : '" + code + '\'' +
                ", description : '" + description + '\'' +
                ", prix : '" + price + "$'}\n";
    }

    public Map<IngredientAuMenu, Integer> getIngredients() { return ingredients; }

    public void setIngredients(IngredientAuMenu ingredient, Integer quantity) {
        this.ingredients.put(ingredient, quantity);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
