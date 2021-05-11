package menufact.plats;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant(){}

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) { this.proportion = proportion; }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatEnfant : {" +
                "proportion : '" + proportion +
                "'} => " + super.toString();
    }
}
