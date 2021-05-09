package ingredients.Factory;

import ingredients.Epice;
import ingredients.Ingredient;

public class FactoryEpice extends FactoryIngredients{
    public FactoryEpice() {
    }

    public Epice createIngredients(){
        return new Epice();
    }
}
