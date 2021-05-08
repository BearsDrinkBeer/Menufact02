package menufact.plats;

public class FactoryPlatEnfant extends FactoryPlatAuMenu{
    public FactoryPlatEnfant(){}
    @Override
    public PlatEnfant createPlat(){
        return new PlatEnfant();
    }
}
