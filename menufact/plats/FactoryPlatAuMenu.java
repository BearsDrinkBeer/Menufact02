package menufact.plats;

public class FactoryPlatAuMenu implements FactoryPlat{
    public FactoryPlatAuMenu(){}
    @Override
    public PlatAuMenu createPlat() { return new PlatAuMenu(); }
}
