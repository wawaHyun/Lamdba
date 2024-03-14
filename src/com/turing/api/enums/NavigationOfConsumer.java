package com.turing.api.enums;

import com.turing.api.Main;
import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.product.ProductView;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public enum NavigationOfConsumer {
    USER("User",i->{
        while (UserRouter.getUserRouter(i).equals(true)){
            System.out.println(" ");
        }
    }),
    PRODUCT("product", ProductView::proMain),
    BOARD("board",i->{
        BoardView.boMain();
    }),
    BANK("bank",i->{
        AccountView.accountMain(i);
    }),
    CRAWLER("crawler",i-> {
        try {
            CrawlerView.crawlerMain(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    ARTICLE("Article",i->{
        ArticleView.artiMain(i);
    }),
    WRONG("Wrong",i->{
        System.out.println("Wrong input.");
    }),
    EXIT("exit",i->{
        System.out.println("OK,");
        System.out.println("System Down, System Down..!");
        System.exit(0);
    }),
    MENUCARE("menucare",i->{
        while (MenuRouter.getMenuRouter(i)){};
    })
    ;
    private final String name;
    private final Consumer<Scanner> consu;

    NavigationOfConsumer(String name, Consumer<Scanner> consu) {
        this.name = name;
        this.consu = consu;
    }

    public static void getNavigation(Scanner sc) {
        while (true) {
            System.out.println("exit, 'User' auth, product, " +
                    "com.turing.api.'board', 'bank' program, crawler, " +
                    "Article, menucare");
            String select = sc.next();
            Stream.of(NavigationOfConsumer.values())
                    .filter(i -> i.name.equals(select))
                    .findAny().orElse(WRONG)
                    .consu.accept(sc);
        }

    }
}
