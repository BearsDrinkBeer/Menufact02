package menufact.plats;

public class FactoryPlatSante extends FactoryPlatAuMenu{
    public FactoryPlatSante(){}
    @Override
    public PlatSante createPlat() {
        return new PlatSante();
    }
}
