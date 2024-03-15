package com.turing.api.enums;

import com.turing.api.Menu.Menu;
import com.turing.api.Menu.MenuController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MenuRouter {
    TOUCH("touch",i-> {
        try {
            MenuController.getInsteance().menuTouch(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ADDMENU("add",i-> {
        try {
            MenuController.getInsteance().menuInsert(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    RMMENU("rm",i-> {
        try {
            MenuController.getInsteance().menueRm(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    LSMENU("ls",i-> {
        try {
                MenuController.getInsteance().menuLs();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    AllInsertMenu("alin",i-> {
            MenuController.getInsteance().menuAllInsert();
        return true;
    }),
    WRONG("wrong",i-> {
        System.out.println("Wrong input.");
        return true;
    }),
    EXIT("go",i-> {
        System.out.println("Menu handling has ended.");
        return false;
    })

    ;
    private final String name;
    private final Predicate<Scanner> predi;

    MenuRouter(String name, Predicate<Scanner> predi) {
        this.name = name;
        this.predi = predi;
    }
    public static boolean getMenuRouter(Scanner sc){
        System.out.println("'go' to Main menu, touch, add Menu, rm Menu, ls menu, alin-All Insert Menu");
        String select = sc.next();
        return Stream.of(MenuRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(WRONG)
                .predi.test(sc);
    }
}
