package MVC.Model;

public enum Action {
    POUR("Налить"),
    STIR("Размешать"),
    SHAKE("Взболтать"),
    ADD("Добавить"),
    WAIT("Подождать");

    /**
     * @param description описание действий
     */
    private final String description;
    Action(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
