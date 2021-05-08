package menufact.plats;

import ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class PlatAuMenu {
    private int code;
    private String description;
    private double price;
    private Map<Ingredient, Integer> ingredients = new HashMap<>();

    public PlatAuMenu(){}

    public PlatAuMenu(int code, String description, double prix, Map<Ingredient, Integer> ingredients) {
        this.code = code;
        this.description = description;
        this.price = prix;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu : {" +
                "code : '" + code + '\'' +
                ", description : '" + description + '\'' +
                ", prix : '" + price + "$'}\n";
    }

    public Map<Ingredient, Integer> getIngredients() { return ingredients; }

    public void setIngredients(Map<Ingredient, Integer> ingredients) { this.ingredients = ingredients; }

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
