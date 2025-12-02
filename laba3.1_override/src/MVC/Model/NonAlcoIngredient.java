package MVC.Model;

public class NonAlcoIngredient extends Ingredient {

        public NonAlcoIngredient(String name, double volumeML) {
            super(name, volumeML);
        }

        @Override
        public double getAlcoholPercent() {
            return 0.0;
        }
    }
