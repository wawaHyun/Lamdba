package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public interface MenuService {
    Messenger menuInsert(Menu menus) throws SQLException;

    Messenger menuRm(Menu menus) throws SQLException;

    Map<Long, Menu> menuLs() throws SQLException;
}
