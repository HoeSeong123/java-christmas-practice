package christmas.model;

import static christmas.model.Menu.BARBEQUE_RIBS;
import static christmas.model.Menu.CAESAR_SALAD;
import static christmas.model.Menu.CHAMPAGNE;
import static christmas.model.Menu.CHOCOLATE_CAKE;
import static christmas.model.Menu.CHRISTMAS_PASTA;
import static christmas.model.Menu.ICE_CREAM;
import static christmas.model.Menu.MUSHROOM_SOUP;
import static christmas.model.Menu.RED_WINE;
import static christmas.model.Menu.SEAFOOD_PASTA;
import static christmas.model.Menu.TAPAS;
import static christmas.model.Menu.T_BONE_STEAK;
import static christmas.model.Menu.ZERO_COLA;

import java.util.List;
import java.util.Set;

public enum Category {
    APPETIZER(List.of(MUSHROOM_SOUP, TAPAS, CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK, BARBEQUE_RIBS, SEAFOOD_PASTA, CHRISTMAS_PASTA)),
    DESSERT(List.of(CHOCOLATE_CAKE, ICE_CREAM)),
    BEVERAGE(List.of(ZERO_COLA, RED_WINE, CHAMPAGNE));

    private List<Menu> menus;

    Category(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public static boolean areOnlyBeverage(Set<String> items) {
        return items.stream().allMatch(item ->
                BEVERAGE.getMenus().stream().anyMatch(menu -> menu.getName().contains(item)));
    }

    public static boolean isDessertMenu(String menuName) {
        return DESSERT.getMenus().stream()
                .anyMatch(menu -> menu.getName().equals(menuName));
    }

    public static boolean isMainMenu(String menuName) {
        return MAIN.getMenus().stream()
                .anyMatch(menu -> menu.getName().equals(menuName));
    }
}
