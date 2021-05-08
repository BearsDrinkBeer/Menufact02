package menufact.plats;

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(){}

    @Override
    public String toString() {
        return "menufact.plats.PlatSante : {" +
                "kcal : '" + kcal + '\'' +
                ", chol : '" + chol + '\'' +
                ", gras '" + gras +
                "'} => " + super.toString();
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) { this.kcal = kcal; }

    public double getChol() {
        return chol;
    }

    public void setChol(double chol) { this.chol = chol; }

    public double getGras() {
        return gras;
    }

    public void setGras(double gras) { this.gras = gras; }
}
