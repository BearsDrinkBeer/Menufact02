package ingredients.factory;

public class FactoryViande implements FactoryIngredient {
    public FactoryViande() {}

    public Viande createIngredients(){
        return new Viande();
    }
}
