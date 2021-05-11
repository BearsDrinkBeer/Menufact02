package ingredients.factory;

public class FactoryEpice implements FactoryIngredient {
    public FactoryEpice() {}

    @Override
    public Epice createIngredients(){
        return new Epice();
    }
}
