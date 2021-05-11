package ingredients.factory;

public class FactoryLegume implements FactoryIngredient {
    public FactoryLegume() {}

    public Legume createIngredients(){
        return new Legume();
    }
}
