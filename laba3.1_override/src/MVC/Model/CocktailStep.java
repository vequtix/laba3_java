package MVC.Model;

/**
 * шаг в приготовлении коктейля - состоит из действия "MVC.Model.Action" и ингредиента "MVC.Model.Ingredient"
 */
public class CocktailStep {
    private Action action;
    private Ingredient ingredient;

    /**
     * создает шаг рецепта с действием и ингредиентом
     * @param action действие над ингредиентом, например: POUR - налить
     * @param ingredient ингредиент над которым выполняется действие
     */
    public CocktailStep(Action action, Ingredient ingredient) {
        this.action = action;
        this.ingredient = ingredient;
    }

    /**
     * шаг рецепта только с действием (без ингредиента) к примеру: взболтать или подождать
     * @param action действие
     */
    public CocktailStep(Action action) {
        this(action, null);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Action getAction() {
        return action;
    }
}
