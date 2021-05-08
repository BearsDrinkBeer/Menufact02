package menufact.state;

import menufact.plats.PlatChoisi;

public class Impossible extends StatePreparation{
    public Impossible(PlatChoisi plat) { super(plat); }

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
        this.plat.setState(new Impossible(this.plat));
    }
}
