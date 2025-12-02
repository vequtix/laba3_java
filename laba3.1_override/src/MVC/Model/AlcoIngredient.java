package MVC.Model;

public class AlcoIngredient extends Ingredient {
    private final double alcoholPercent;

    public AlcoIngredient(String name, double volumeML, double alcoholPercent) {
        super(name, volumeML);
        this.alcoholPercent = alcoholPercent;
    }

    @Override
    public double getAlcoholPercent() {
        return this.alcoholPercent;
    }
}
