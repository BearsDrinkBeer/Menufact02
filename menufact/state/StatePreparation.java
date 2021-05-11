package menufact.state;

public abstract class StatePreparation {
    protected PlatChoisi plat;
    protected String state;

    /**
     * @param plat est le plat auquel on veut modifer l'etat
     */
    public StatePreparation(PlatChoisi plat){
        this.plat = plat;
    }

    public abstract void commande();
    public abstract void preparation();
    public abstract void termine();
    public abstract void servi();
    public abstract void impossible();

    /**
     * @return l'etat du plat
     */
    @Override
    public String toString(){
        return "etat : '" + state + '\'';
    }
}
