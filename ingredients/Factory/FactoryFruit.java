package ingredients.Factory;

import ingredients.Fruit;
import ingredients.Ingredient;

public class FactoryFruit extends FactoryIngredients {
    public FactoryFruit() {
    }

    public Fruit createIngredients(){
        return new Fruit();
    }
}
