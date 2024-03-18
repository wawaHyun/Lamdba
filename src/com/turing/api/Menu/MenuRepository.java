package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    PreparedStatement pstmt;
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
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,menus.getCategory());
        pstmt.setString(2,menus.getMenuItem());

        System.out.println(menus.toString());
        return (pstmt.executeUpdate()<0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger menuRm() throws SQLException {
        String sql = "Drop table memus";
        pstmt = conn.prepareStatement(sql);
        return (pstmt.executeUpdate()>0)? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger menueOneRm(String rm) throws SQLException {
        String sql = "DELETE FROM menus Where category = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,rm);
        return (pstmt.executeUpdate()>0)? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Menu menuLs() throws SQLException {
        Menu menus = new Menu();
        String sql = "select * from menus";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            do {
                menus.setId(rs.getLong("id"));
              menus.setCategory(rs.getString("category"));
              menus.setMenuItem(rs.getString("menuitem"));

            } while (rs.next());
        } else {
            System.out.println("data is notings.");
        }
        return menus;
    }


    public Messenger menuAllInsert(Menu menu) {
        String sql = "INSERT INTO menus(category, menuitem) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getMenuItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getMenuItem());
            return Messenger.FAIL;
        }
    }

    public List<?> getMenusByCategory(String category) {
        String sql = "SELECT menuitem FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while(rs.next())menus.add(Menu.builder()
                    .menuItem(rs.getString(1))
                    .build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;

    }

    public Messenger menuTouch(Scanner sc) throws SQLException {
        String sql = "CREATE table"+sc+"(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, category VARCHAR(20), menuitem VARCHAR(80)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.execute(sql);
            System.out.println("생성완");
        } catch (Exception e) {
            System.out.println("문제 발생");
            sql = "";
        }
        return (sql.isEmpty()) ? Messenger.FAIL : Messenger.SUCCESS;
    }

    public Messenger returnMessenger() throws SQLException {
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        Messenger m = null;
        return Messenger.SUCCESS;
    }

    public Menu returnMenu() {
        return null;
    }

    public List<?> returnAllMenu() {
        return null;
    }
}
