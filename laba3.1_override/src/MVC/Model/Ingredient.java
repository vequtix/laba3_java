package MVC.Model;

/**
 * Абстрактный базовый класс для всех ингредиентов.
 * Определяет общие свойства, такие как название и объем.
 */
public abstract class Ingredient {
    protected String name;
    protected double volumeML;

    public Ingredient(String name, double volumeML) {
        this.name = name;
        this.volumeML = volumeML;
    }

    public String getName() {
        return name;
    }

    public double getVolumeML() {
        return volumeML;
    }

    public abstract double getAlcoholPercent();
}
