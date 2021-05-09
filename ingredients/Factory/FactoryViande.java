package ingredients.Factory;

import ingredients.Ingredient;
import ingredients.Viande;

public class FactoryViande extends FactoryIngredients {
    public FactoryViande() {
    }

    public Viande createIngredients(){
        return new Viande();
    }
}
