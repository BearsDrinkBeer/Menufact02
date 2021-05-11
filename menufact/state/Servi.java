package menufact.state;

public class Servi extends StatePreparation{
    public Servi(PlatChoisi plat) {
        super(plat);
        this.state = "Servi";
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
        this.plat.setState(new Servi(this.plat));
    }

    @Override
    public void impossible() {
        //TODO
    }
}
