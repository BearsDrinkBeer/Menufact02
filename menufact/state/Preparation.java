package menufact.state;

import menufact.plats.PlatChoisi;

public class Preparation extends StatePreparation{

    /**
     * @param plat
     */
    public Preparation(PlatChoisi plat) {
        super(plat);
        this.state = "Preparation";
    }

    @Override
    public void commande() {
        //TODO
    }

    /**
     *
     */
    @Override
    public void preparation() {
        this.plat.setState(new Preparation(this.plat));
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
