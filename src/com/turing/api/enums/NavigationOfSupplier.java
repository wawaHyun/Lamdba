package com.turing.api.enums;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.product.ProductView;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum NavigationOfSupplier {
    USER("User",()->{
        while (UserRouter.getUserRouter(NavigationOfSupplier.getSuppScanner()).equals(true)){
            System.out.println(" ");
        }
        return "your User process is done.\n welcome back.";
    }),
    PRODUCT("product",()->{
        ProductView.proMain(NavigationOfSupplier.getSuppScanner());
        return "your product process is done.\n welcome back.";

    }),
    BOARD("board",()->{
        BoardView.boMain();
        return "your board process is done.\n welcome back.";
    }),
    BANK("bank",()->{
        AccountView.accountMain(NavigationOfSupplier.getSuppScanner());
        return "your bank process is done.\n welcome back.";
    }),
    CRAWLER("crawler",()-> {
        try {
            CrawlerView.crawlerMain(NavigationOfSupplier.getSuppScanner());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "your crawler process is done.\n welcome back.";
    }),
    ARTICLE("Article",()->{
        ArticleView.artiMain(NavigationOfSupplier.getSuppScanner());
        return "your Article process is done.\n welcome back.";
    }),
    WRONG("Wrong",()->{
        System.out.println("Wrong input.");
        return "Wrong";
    }),
    EXIT("exit",()->{
        System.out.println("OK,");
        System.out.println("System Down, System Down..!");
        return "exit";
    }),
    MENUCARE("menucare",()->{
        while (MenuRouter.getMenuRouter(NavigationOfSupplier.getSuppScanner())){};
        return "menu control is done.";
    })
    ;
    private final String name;
    private final Supplier<String> supp;

    NavigationOfSupplier(String name, Supplier<String> supp) {
        this.name = name;
        this.supp = supp;
    }

    public static Scanner getSuppScanner(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    public static String getNavigation() {
        System.out.println("exit, 'User' auth, product, " +
                "com.turing.api.'board', 'bank' program, crawler, " +
                "Article, menucare");
        Scanner sc = NavigationOfSupplier.getSuppScanner();
        String select = sc.next();
        return Stream.of(NavigationOfSupplier.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(WRONG)
                .supp.get();
    }
}
