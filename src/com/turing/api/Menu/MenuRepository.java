package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository {
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection conn;
    PreparedStatement prstmt;
    ResultSet rs;

    public MenuRepository() throws SQLException {
        this.conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
    }

    public static MenuRepository getInstance() {
        return instance;
    }

    public Messenger menuInsert(Menu menus) throws SQLException {
        String sql = "INSERT INTO menus (category, menuitem)" +
                "VALUES (?,?)";
        prstmt = conn.prepareStatement(sql);

        prstmt.setString(1,menus.getCategory());
        prstmt.setString(2,menus.getMenuItem());

        System.out.println(menus.toString());
        return (prstmt.executeUpdate()<0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger menuRm(Menu menus) throws SQLException {
        System.out.println("menuRm");
        String sql = "DELETE FROM menus Where "+menus.getCategory();
        prstmt = conn.prepareStatement(sql);



        return (prstmt.executeUpdate()>0)? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Map<Long, Menu> menuLs() throws SQLException {
        Map<Long,Menu> menuMap = new HashMap<>();
        String sql = "select * from menus";
        prstmt = conn.prepareStatement(sql);
        rs = prstmt.executeQuery();

        while (rs.next()){
            Long key = rs.getLong("id");
            menuMap.put(key,Menu.builder()
                    .id(key)
                    .category(rs.getString("category"))
                    .menuItem(rs.getString("menuItem"))
                    .build());
        }
        return menuMap;
    }


}
