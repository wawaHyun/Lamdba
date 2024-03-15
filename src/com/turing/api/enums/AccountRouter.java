package com.turing.api.enums;

import com.turing.api.Menu.Menu;
import com.turing.api.Menu.MenuController;
import com.turing.api.User.UserController;
import com.turing.api.account.AccountController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("0",i->{
        System.out.println("back menu.");
        return false;
    }),
    CREATEACCOUNT("1",i->{
        AccountController.getInstance().createAccount(i);
        return true;
    }),
    DEPOSIT("2",i->{
        AccountController.getInstance().deposit(i);
        return true;
    }),
    WITHDRAW("3",i->{
        AccountController.getInstance().withdraw(i);
        return true;
    }),
    BALANCE("4",i->{
        AccountController.getInstance().getBalance(i);
        return true;
    }),
    DELETE("5",i->{
        AccountController.getInstance().cancelAccount(i);
        return true;
    }),
    GETACCOUNT("6",i->{
        AccountController.getInstance().getAccount();
        return true;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predi;

    AccountRouter(String name, Predicate<Scanner> predi) {
        this.name = name;
        this.predi = predi;
    }
    public static Boolean getAccoRouter(Scanner sc) {
        System.out.println("[MENU]");
        MenuController.getInsteance().getMenusByCategory("account").forEach(i -> System.out.print(((Menu)i).getMenuItem() + ", "));
        System.out.println();

        String select = sc.next();
        return Stream.of(AccountRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(AccountRouter.EXIT)
                .predi.test(sc);
    }
}
