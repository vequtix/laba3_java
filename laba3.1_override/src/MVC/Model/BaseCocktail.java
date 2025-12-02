package MVC.Model;

import java.util.List;

public abstract class BaseCocktail {

    public abstract String getName();

    public abstract List<CocktailStep> getRecipe();

    /**
     * общая логика для расчета крепости
     * @return крепость напитка в процентах
     */
    public double calculateStrength() {
        double totalVolume = 0;
        double totalAlcoholVolume = 0;

        for (CocktailStep step : getRecipe()) {
            if (step.getIngredient() != null) {
                Ingredient ingredient = step.getIngredient();
                totalVolume += ingredient.getVolumeML();
                totalAlcoholVolume += ingredient.getVolumeML() * (ingredient.getAlcoholPercent() / 100.0);
            }
        }
        if (totalVolume == 0) {
            return 0.0;
        }
        return (totalAlcoholVolume / totalVolume) * 100;
    }
}
