package com.turing.api.enums;

import com.turing.api.account.AccountController;
import com.turing.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    EXIT("exit",i->{
        System.out.println("back menu.");
        return false;
    }),
    ARTICLE("article",i->{
        try {
            ArticleController.getInstance().findArticleByWeb();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predi;

    ArticleRouter(String aaname, Predicate<Scanner> predi) {
        this.name = aaname;
        this.predi = predi;
    }

    public static Boolean getArtiRouter(Scanner sc) {
        String select = sc.next();
        System.out.println("'exit'back menu, article");
        return Stream.of(ArticleRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(ArticleRouter.EXIT)
                .predi.test(sc);
    }
}
