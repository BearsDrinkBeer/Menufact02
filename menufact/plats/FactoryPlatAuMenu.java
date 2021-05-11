package menufact.plats;

public class FactoryPlatAuMenu implements FactoryPlat{
    public FactoryPlatAuMenu(){}

    /**
     * @return
     */
    @Override
    public PlatAuMenu createPlat() { return new PlatAuMenu(); }
}
