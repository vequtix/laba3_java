package MVC;
import MVC.Model.CocktailStep;

import java.util.List;

public class View {
    /**
     * вывод
     * @param name название коктейля
     * @param cocktailRecipe список для приготовления
     * @param strength рассчитанная крепость алкоголя
     */
    public void printCocktailInfo(String name, List<CocktailStep> cocktailRecipe, double strength) {
        System.out.println("Коктейль: " + name);
        System.out.println("Рецепт: ");
        for (CocktailStep step : cocktailRecipe) {
            String ingredientInfo = "";
            if (step.getIngredient() != null) {
                ingredientInfo = " (" + step.getIngredient().getName() + ")";
            }
            System.out.println(" - " + step.getAction().getDescription() + ingredientInfo);
        }
        System.out.println("Крепость коктейля составляет: " + strength + "%");
    }
}
