package menufact.state;

import menufact.plats.PlatChoisi;

public class Termine extends StatePreparation{

    /**
     * @param plat
     */
    public Termine(PlatChoisi plat) {
        super(plat);
        this.state = "Termine";
    }

    @Override
    public void commande() {
        //TODO
    }

    @Override
    public void preparation() {
        //TODO
    }

    /**
     *
     */
    @Override
    public void termine() {
        this.plat.setState(new Termine(this.plat));
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
