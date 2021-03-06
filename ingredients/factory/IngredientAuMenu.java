package ingredients.factory;

import ingredients.bridge.IngredientEtat;

public abstract class IngredientAuMenu implements Ingredient {

    private String nom;
    private String description;
    private IngredientEtat etat;
    protected TypeIngredient type;

    public IngredientAuMenu() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IngredientEtat getEtat() {
        return etat;
    }

    public void setEtat(IngredientEtat etat) {
        this.etat = etat;
    }

    public TypeIngredient getType() {
        return type;
    }

    public void setType(TypeIngredient type) {
        this.type = type;
    }

    /**
     * @return le nom, la description, l'etat et le type de l'ingredient
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "nom : '" + nom + '\'' +
                ", description : '" + description + '\'' +
                ", " + etat +
                ", type : '" + type +
                "'}";
    }
}
