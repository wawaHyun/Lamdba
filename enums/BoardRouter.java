package com.turing.api.enums;

import com.turing.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum BoardRouter {
    EXIT("exit",i->{
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
        String select = sc.next();
        System.out.println("'exit'back menu, board is nothing.");
        return Stream.of(BoardRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(BoardRouter.EXIT)
                .predi.test(sc);
    }
}
