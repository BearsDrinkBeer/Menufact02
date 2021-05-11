package menufact.factory;

import menufact.state.Commande;
import menufact.state.StatePreparation;

public class PlatChoisi {
    private StatePreparation state;
    private PlatAuMenu plat;
    private int quantite;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.state = new Commande(this);
    }

    /**
     * @return la quantite, l'etat et le plat.
     */
    @Override
    public String toString() {
        return "menufact.factory.PlatChoisi : {" +
                "quantite : '" + quantite + '\'' +
                ", " + state +
                ", plat : '" + plat + "'}\n";
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public StatePreparation getState() { return state; }

    public void setState(StatePreparation state) { this.state = state; }
}
