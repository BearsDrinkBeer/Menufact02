package menufact.state;

import menufact.plats.PlatChoisi;

public class Servi extends StatePreparation{
    public Servi(PlatChoisi plat) {
        super(plat);
        this.state = "Servi";
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
