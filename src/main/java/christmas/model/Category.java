package christmas.model;

public enum Category {
    APPETIZER("src/main/java/resources/appetizer-menu.md"),
    MAIN("src/main/java/resources/main-menu.md"),
    DESSERT("src/main/java/resources/dessert-menu.md"),
    BEVERAGE("src/main/java/resources/beverage-menu.md");

    private String path;

    Category(String path) {
        this.path = path;
    }
}
