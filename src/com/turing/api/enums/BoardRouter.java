package com.turing.api.enums;

import com.turing.api.Menu.Menu;
import com.turing.api.Menu.MenuController;
import com.turing.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum BoardRouter {
    EXIT("x",i->{
        System.out.println("back menu.");
        return false;
    }),
    mk("mk",i->{
        System.out.println("back menu.");
        return false;
    }),
    touch("touch",i->{
        System.out.println("back menu.");
        return false;
    }),
    with("with",i->{
        System.out.println("back menu.");
        return false;
    }),
    depo("depo",i->{
        System.out.println("back menu.");
        return false;
    }),
    bal("bal",i->{
        System.out.println("back menu.");
        return false;
    }),
    rm("rm",i->{
        System.out.println("back menu.");
        return false;
    }),
    cat("cat",i->{
        System.out.println("back menu.");
        return false;
    }),
    lsa("ls-a",i->{
        System.out.println("back menu.");
        return false;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predi;

    BoardRouter(String name, Predicate<Scanner> predi) {
        this.name = name;
        this.predi = predi;
    }

    public static Boolean getBoadRouter(Scanner sc) {
        System.out.println("[MENU]");
        MenuController.getInsteance().getMenusByCategory("board").forEach(i -> System.out.print(((Menu)i).getMenuItem() + ", "));
        System.out.println();
        String select = sc.next();
        return Stream.of(BoardRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(BoardRouter.EXIT)
                .predi.test(sc);
    }
}
