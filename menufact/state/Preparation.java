package menufact.state;

public class Preparation extends StatePreparation{

    public Preparation(PlatChoisi plat) {
        super(plat);
        this.state = "Preparation";
    }

    @Override
    public void commande() {
        //TODO
    }

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
