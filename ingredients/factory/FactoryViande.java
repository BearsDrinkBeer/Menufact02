package ingredients.Factory;

import ingredients.Viande;

public class FactoryViande implements FactoryIngredient {
    public FactoryViande() {}

    public Viande createIngredients(){
        return new Viande();
    }
}
