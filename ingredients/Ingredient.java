package ingredients;

import ingredients.Bridge.IngredientEtat;

public interface Ingredient {
    String getNom();

    void setNom(String nom);

    String getDescription();

    void setDescription(String description);

    IngredientEtat getEtat();

    void setEtat(IngredientEtat etat);

    TypeIngredient getType();

    void setType(TypeIngredient type);
}
