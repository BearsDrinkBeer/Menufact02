package menufact.plats;

public class FactoryPlatEnfant implements FactoryPlat{
    public FactoryPlatEnfant(){}
    @Override
    public PlatEnfant createPlat(){
        return new PlatEnfant();
    }
}
