package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService{
    private static MenuServiceImpl instance = new MenuServiceImpl();

    MenuRepository menu;
    public MenuServiceImpl() {
        this.menu = MenuRepository.getInstance();
    }

    public static MenuServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger menuInsert(Menu menus) throws SQLException {
        return menu.menuInsert(menus);
    }

    @Override
    public Messenger menuRm(Menu menus) throws SQLException {
        return menu.menuRm(menus);
    }

    @Override
    public Map<Long, Menu> menuLs() throws SQLException {
        return menu.menuLs();
    }
}
