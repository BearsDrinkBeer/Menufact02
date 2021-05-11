package menufact.plats;

import ingredients.factory.IngredientAuMenu;

import java.util.Map;

public interface Plat {
    Map<IngredientAuMenu, Integer> getIngredients();

    void setIngredients(IngredientAuMenu ingredient, Integer quantity);

    int getCode();

    void setCode(int code);

    String getDescription();

    void setDescription(String description);

    double getPrice();

    void setPrice(double price);
}
