package menufact.plats;

public class FactoryPlatSante implements FactoryPlat{
    public FactoryPlatSante(){}

    @Override
    public PlatSante createPlat() {
        return new PlatSante();
    }
}
