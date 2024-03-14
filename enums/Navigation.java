package com.turing.api.enums;

import com.turing.api.User.UserController;

import com.turing.api.account.AccountView;
import com.turing.api.article.Article;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.product.Product;
import com.turing.api.product.ProductView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {

    USER("User",i->{
        while (UserRouter.getUserRouter(i).equals(true)){
            System.out.println(" ");
        }
        return true;
    }),
    PRODUCT("product",i->{
            ProductView.proMain(i);
        return true;

    }),
    BOARD("board",i->{
        BoardView.boMain();
        return true;
    }),
    BANK("bank",i->{
        AccountView.accountMain(i);
        return true;
    }),
    CRAWLER("crawler",i-> {
        try {
            CrawlerView.crawlerMain(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ARTICLE("Article",i->{
        ArticleView.artiMain(i);
        return true;
    })
    ;
    private final String name;
    private final Predicate<Scanner> predi;

    Navigation(String name, Predicate<Scanner> predi) {
        this.name = name;
        this.predi = predi;
    }
    public static Boolean getNavigation(Scanner sc){
        System.out.println("'User' auth, product, " +
                "com.turing.api.'board', 'bank' program, crawler, " +
                "Article");
        String select = sc.next();
        return Stream.of(Navigation.values())
                .filter(i->i.name.equals(select))
                .findAny().orElseThrow(()->new IllegalAccessError("Wrong input"))
                .predi.test(sc);
    }

}
