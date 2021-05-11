package menufact.plats;

public class FactoryPlatSante implements FactoryPlat{
    public FactoryPlatSante(){}

    /**
     * @return
     */
    @Override
    public PlatSante createPlat() {
        return new PlatSante();
    }
}
