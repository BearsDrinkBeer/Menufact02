package menufact.plats;

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

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi : {" +
                "quantite : '" + quantite + '\'' +
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
