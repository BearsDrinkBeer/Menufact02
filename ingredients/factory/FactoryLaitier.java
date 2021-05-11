package ingredients.Factory;

import ingredients.Laitier;

public class FactoryLaitier implements FactoryIngredient {
    public FactoryLaitier() {}

    @Override
    public Laitier createIngredients(){
        return new Laitier();
    }
}
