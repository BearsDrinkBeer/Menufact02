package menufact.state;

import menufact.plats.PlatChoisi;

public class Commande extends StatePreparation{
    public Commande(PlatChoisi plat) { super(plat); }

    @Override
    public void commande() {
        this.plat.setState(new Commande(this.plat));
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
