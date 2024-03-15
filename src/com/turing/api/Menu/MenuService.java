package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface MenuService {
    Messenger menuInsert(Menu menus) throws SQLException;

    Messenger menuRm(String rm) throws SQLException;
    void menuAllInsert();

    Menu menuLs() throws SQLException;
    List<?> getMenusByCategory(String category);

    Messenger menuTouch(Scanner sc) throws SQLException;
}
