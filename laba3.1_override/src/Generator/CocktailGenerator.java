package Generator;

import java.util.*;
import MVC.Model.*; // импортируй свои классы коктейлей, ингредиентов и т.д.

public class CocktailGenerator {

    private static Random rand = new Random();

    public static BaseCocktail generateRandomCocktail() {
        List<CocktailStep> steps = new ArrayList<>();
        int stepsCount = 2 + rand.nextInt(3); // 2-4 шага

        for (int i = 0; i < stepsCount; i++) {
            boolean isAlcohol = rand.nextBoolean();
            if (isAlcohol) {
                steps.add(new CocktailStep(Action.POUR, new AlcoIngredient("Алко" + i, 30, 40)));
            } else {
                steps.add(new CocktailStep(Action.ADD, new NonAlcoIngredient("Неалко" + i, 20)));
            }
        }
        return new ClassicCocktail("РандомныйКоктейль", steps);
    }
}

