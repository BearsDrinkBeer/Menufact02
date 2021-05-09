package menufact.observer;

import ingredients.Ingredient;
import inventaire.IngredientInventaire;
import menufact.plats.PlatChoisi;
import menufact.state.Impossible;
import menufact.state.StatePreparation;
import menufact.state.Termine;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Chef implements EventListener{
    private StatePreparation state;
    private Queue<PlatChoisi> platsChoisis = new LinkedList<>();
    private Map<Ingredient, Integer> inventaire = IngredientInventaire.getInventaire().getIngredients();

    @Override
    public void update(PlatChoisi plat) {
        platsChoisis.add(plat);
        this.preparation();
    }

    private boolean verify(PlatChoisi plat){
        Map<Ingredient, Integer> ingredients = plat.getPlat().getIngredients(); //Ingredients du plat au menu
        for(Map.Entry<Ingredient, Integer> ingredient : ingredients.entrySet()){
            if(ingredient.getValue() * plat.getQuantite() > inventaire.get(ingredient.getKey())){
                return false;
            }
        }
        return true;
    }

    public void preparation(){
        for(PlatChoisi plat : platsChoisis){
            if(verify(plat)) {
                state = new Termine(plat);
                state.termine();
            }
            else {
                state = new Impossible(plat);
                state.impossible();
            }
            platsChoisis.remove(plat);
        }
    }
}
