package ingredients.Factory;

import ingredients.Ingredient;
import ingredients.Laitier;

public class FactoryLaitier extends FactoryIngredients {
    public FactoryLaitier() {
    }

    public Laitier createIngredients(){
        return new Laitier();
    }
}
