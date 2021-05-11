package menufact.state;

import menufact.plats.PlatChoisi;

public class Commande extends StatePreparation{

    /**
     * @param plat
     */
    public Commande(PlatChoisi plat) {
        super(plat);
        this.state = "Commande";
    }

    /**
     *
     */
    @Override
    public void commande() {
        this.plat.setState(new Commande(this.plat));
    }

    @Override
    public void preparation() {
        //TODO
    }

    @Override
    public void termine() {
        //TODO
    }

    @Override
    public void servi() {
        //TODO
    }

    @Override
    public void impossible() {
        //TODO
    }
}
