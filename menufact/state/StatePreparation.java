package menufact.state;

import menufact.plats.PlatChoisi;

public abstract class StatePreparation {
    protected PlatChoisi plat;
    protected String state;

    public StatePreparation(PlatChoisi plat){
        this.plat = plat;
    }

    public abstract void commande();
    public abstract void preparation();
    public abstract void termine();
    public abstract void servi();
    public abstract void impossible();

    @Override
    public String toString(){
        return "etat : '" + state + '\'';
    }
}
