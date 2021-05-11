package ingredients.Factory;

import ingredients.Epice;

public class FactoryEpice implements FactoryIngredient {
    public FactoryEpice() {}

    @Override
    public Epice createIngredients(){
        return new Epice();
    }
}
