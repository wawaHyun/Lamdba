package com.turing.api.enums;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.product.ProductView;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    USER("User",i->{
        while (UserRouter.getUserRouter(i).equals(true)){
            System.out.println(" ");
        }
        return "your User process is done.\n welcome back.";
    }),
    PRODUCT("product",i->{
        ProductView.proMain(i);
        return "your product process is done.\n welcome back.";

    }),
    BOARD("board",i->{
        BoardView.boMain();
        return "your board process is done.\n welcome back.";
    }),
    BANK("bank",i->{
        AccountView.accountMain(i);
        return "your bank process is done.\n welcome back.";
    }),
    CRAWLER("crawler",i-> {
        try {
            CrawlerView.crawlerMain(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "your crawler process is done.\n welcome back.";
    }),
    ARTICLE("Article",i->{
        ArticleView.artiMain(i);
        return "your Article process is done.\n welcome back.";
    }),
    WRONG("Wrong",i->{
        System.out.println("Wrong input.");
        return "Wrong";
    }),
    EXIT("exit",i->{
        System.out.println("OK,");
        System.out.println("System Down, System Down..!");
        return "exit";
    }),
    MENUCARE("menucare",i->{
        while (MenuRouter.getMenuRouter(i)){}
        return "menu control is done.";
    })
    ;
    private final String name;
    private final Function<Scanner,String> func;

    NavigationOfFunction(String name, Function<Scanner, String> func) {
        this.name = name;
        this.func = func;
    }

    public static String getNavigation(Scanner sc) {
        System.out.println("'User' auth, product, " +
                "com.turing.api.'board', 'bank' program, crawler, " +
                "Article, menucare");
        String select = sc.next();
        return Stream.of(NavigationOfFunction.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(WRONG)
                .func.apply(sc);
    }
}
