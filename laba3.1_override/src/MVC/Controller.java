package MVC;
import MVC.Model.BaseCocktail;

public class Controller {
    private BaseCocktail model;
    private View view;

    /**
     * контроллер
     * @param model модель данных
     * @param view модель для отображения данных
     */
    public Controller(BaseCocktail model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * процесс приготовления
     */
    public void prepareCocktail() {
        double strength = model.calculateStrength();
        view.printCocktailInfo(model.getName(), model.getRecipe(), strength);
    }
}
