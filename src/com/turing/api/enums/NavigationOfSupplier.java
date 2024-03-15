package com.turing.api.enums;

import com.turing.api.Menu.Menu;
import com.turing.api.Menu.MenuController;
import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.product.ProductView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum NavigationOfSupplier {
    USER("usr",()->{
        while (UserRouter.getUserRouter(
                NavigationOfSupplier.getSuppScanner()).equals(true)){
            System.out.println();
        }
        return "your User process is done.\nwelcome back.";
    }),
    PRODUCT("product",()->{
        ProductView.proMain(NavigationOfSupplier.getSuppScanner());
        return "your product process is done.\nwelcome back.";

    }),
    BOARD("bbs",()->{
        BoardView.boMain();
        return "your board process is done.\nwelcome back.";
    }),
    BANK("acc",()->{
        AccountView.accountMain(NavigationOfSupplier.getSuppScanner());
        return "your bank process is done.\nwelcome back.";
    }),
    CRAWLER("cwl",()-> {
        try {
            CrawlerView.crawlerMain(NavigationOfSupplier.getSuppScanner());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "your crawler process is done.\nwelcome back.";
    }),
    ARTICLE("art",()->{
        ArticleView.artiMain(NavigationOfSupplier.getSuppScanner());
        return "your Article process is done.\n welcome back.";
    }),
    SOCCER("scc",()->{
        System.out.println("Soccer is nothing.\nback to menu.");
        return "your soccer process is done.\nwelcome back.";
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

    public static String getNavigation() throws SQLException {
        System.out.println("[MENU]");
        MenuController.getInsteance().getMenusByCategory("navigate").forEach(i -> System.out.print(((Menu)i).getMenuItem() + ", "));
        System.out.println();
//        Menu menus = MenuController.getInsteance().menuLs();
//        List<String> list = new ArrayList<>();
//        list.add(menus.getMenuItem());
//        list.forEach(System.out::println);

        Scanner sc = NavigationOfSupplier.getSuppScanner();
        String select = sc.next();
        return Stream.of(NavigationOfSupplier.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(WRONG)
                .supp.get();
    }
}
