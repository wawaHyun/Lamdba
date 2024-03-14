package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class MenuController {
    private static MenuController insteance = new MenuController();

    MenuService menu;

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

    public Messenger menueRm(Scanner sc) throws SQLException {
        System.out.println("Please input the menu to be deleted.");
        return menu.menuRm(Menu.builder()
                .category(sc.next())
                .build());
    }

    public Map<Long, Menu> menuLs() throws SQLException {
        System.out.println("show all menu.");
        return menu.menuLs();
    }
}
