package menufact.observer;

import ingredients.factory.IngredientAuMenu;
import ingredients.singleton.IngredientInventaire;
import menufact.state.PlatChoisi;
import menufact.state.Impossible;
import menufact.state.StatePreparation;
import menufact.state.Termine;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Chef implements EventListener{
    private StatePreparation state;
    private Queue<PlatChoisi> platsChoisis = new LinkedList<>();
    private Map<IngredientAuMenu, Integer> inventaire = IngredientInventaire.getInventaire().getIngredients();

    /**
     * @param plat est le plat a ajouter pour la verification
     */
    @Override
    public void update(PlatChoisi plat) {
        platsChoisis.add(plat);
        this.preparation();
    }

    /**
     * @param plat est le plat a verifier
     * @return vrai si le plat peut etre prepare, sinon retourne faux
     */
    private boolean verify(PlatChoisi plat){
        Map<IngredientAuMenu, Integer> ingredients = plat.getPlat().getIngredients(); //Ingredients du plat au menu
        for(Map.Entry<IngredientAuMenu, Integer> ingredient : ingredients.entrySet()){
            if(ingredient.getValue() * plat.getQuantite() > inventaire.get(ingredient.getKey())){
                return false;
            }
        }
        return true;
    }

    private void preparation(){
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
