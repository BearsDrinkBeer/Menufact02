package menufact.plats;

public class FactoryPlatEnfant implements FactoryPlat{
    public FactoryPlatEnfant(){}

    /**
     * @return
     */
    @Override
    public PlatEnfant createPlat(){
        return new PlatEnfant();
    }
}
