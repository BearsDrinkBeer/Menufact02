package ingredients.Factory;

import ingredients.Ingredient;
import ingredients.Legume;

public class FactoryLegume extends FactoryIngredients {
    public FactoryLegume() {
    }

    public Legume createIngredients(){
        return new Legume();
    }
}
