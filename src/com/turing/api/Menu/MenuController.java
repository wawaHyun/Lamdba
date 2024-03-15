package com.turing.api.Menu;

import com.turing.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuController {
    @Getter
    private static MenuController insteance = new MenuController();
    private final MenuService menu;

    public MenuController() {
        this.menu = MenuServiceImpl.getInstance();
    }

    public static MenuController getInsteance() {
        return insteance;
    }

    public Messenger menuInsert(Scanner sc) throws SQLException {
        System.out.println("Please enter add menu name(20) " +
                "and a description(80).");
        return menu.menuInsert(Menu.builder()
                .category(sc.next())
                .menuItem(sc.next())
                .build());
    }
    public void menuAllInsert() {
        menu.menuAllInsert();
    }
    public Messenger menueRm(Scanner sc) throws SQLException {
        System.out.println("Please input the menu to be deleted.");
        return menu.menuRm(sc.next());
    }

    public Menu menuLs() throws SQLException {
        System.out.println("show all menu.");
        return menu.menuLs();
    }
    public List<?> getMenusByCategory(String category){
        return menu.getMenusByCategory(category);
    }

    public Messenger menuTouch(Scanner sc) throws SQLException {
        return menu.menuTouch(sc);
    }
}
