package MVC.Model;

import java.util.List;

public class ClassicCocktail extends BaseCocktail {
    private final String name;
    private final List<CocktailStep> recipe;

    public ClassicCocktail(String name, List<CocktailStep> recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<CocktailStep> getRecipe() {
        return this.recipe;
    }
}
