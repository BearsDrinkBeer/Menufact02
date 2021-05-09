package menufact.state;

import menufact.plats.PlatChoisi;

public class Termine extends StatePreparation{
    public Termine(PlatChoisi plat) {
        super(plat);
        this.state = "Termine";
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
        this.plat.setState(new Termine(this.plat));
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
