package com.turing.api.Menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
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
    public Messenger menuRm() throws SQLException {
        return menu.menuRm();
    }

    @Override
    public Messenger menuOneRm(String rm) throws SQLException {
        return menu.menueOneRm(rm);
    }


    @Override
    public void menuAllInsert() {
//        String[] categories = {"navigate","account", "article", "board", "user", "soccer"};
//        String[][] menusEunm = {
//                {"exit-exit","account-Account", "board-board", "article-article", "user-user", "soccer-soccer"},
//                {"0-exit","mkdir : account table",  "1-Create account", "2-Deposit", "3-Withdraw",  "4-Balance", "5-Delete", "6-check the my Account info"},
//                {"0-exit","mkdir : article table",  "1-article"},
//                {"0-exit","mkdir : board table",  "1-Board"},
//                {"exit-exit","mkdir : user table",  "join-회원가입", "login-로그인", "findId-ID 검색", "updatePw-PW 변경", "delete-탈퇴", "list-회원목록", "searchName-이름 검색", "searchJob-직업 검색", "count-회원수"},
//                {"0-Exit","mkdir : soccer table",  "1-soccer"}
//                };

        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
                {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk","art"},
                {"x", "mk"},
                {"x", "mk"},
        };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                menu.menuAllInsert(Menu.builder()
                        .category(categories[i])
                        .menuItem(menus[i][j])
                        .build());
    }

    @Override
    public Menu menuLs() throws SQLException {
        return menu.menuLs();
    }

    @Override
    public List<?> getMenusByCategory(String category) {
        return menu.getMenusByCategory(category);
    }

    @Override
    public Messenger menuTouch(Scanner sc) throws SQLException {
        return menu.menuTouch(sc);
    }

    @Override
    public Messenger returnMessenger() throws SQLException {
        return menu.returnMessenger();
    }

    @Override
    public Menu returnMenu() {
        return menu.returnMenu();
    }

    @Override
    public List<?> returnAllMenu() {
        return menu.returnAllMenu();
    }
}
