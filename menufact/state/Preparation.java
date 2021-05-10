package menufact.state;

import menufact.plats.PlatChoisi;

public class Preparation extends StatePreparation{
    public Preparation(PlatChoisi plat) {
        super(plat);
        this.state = "Preparation";
    }

    @Override
    public void commande() {
        //Not implemented yet
    }

    @Override
    public void preparation() {
        //Not implemented yet
    }

    @Override
    public void termine() {
        //Not implemented yet
    }

    @Override
    public void servi() {
        //Not implemented yet
    }

    @Override
    public void impossible() {
        //Not implemented yet
    }
}
