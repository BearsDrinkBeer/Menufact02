package menufact.state;

import menufact.plats.PlatChoisi;

public class Impossible extends StatePreparation{

    /**
     * @param plat
     */
    public Impossible(PlatChoisi plat) {
        super(plat);
        this.state = "Impossible";
    }

    @Override
    public void commande() {
        //TODO
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

    /**
     *
     */
    @Override
    public void impossible() {
        this.plat.setState(new Impossible(this.plat));
    }
}
