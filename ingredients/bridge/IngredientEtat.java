package ingredients.Bridge;

public abstract class IngredientEtat {

    protected String unit;

    public IngredientEtat(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "unit : '" + unit + '\'';
    }
}
