package com.turing.api.enums;

import com.turing.api.User.UserController;
import com.turing.api.account.AccountController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("exit",i->{
        System.out.println("back menu.");
        return false;
    }),
    CREATEACCOUNT("createAccount",i->{
        AccountController.getInstance().createAccount(i);
        return true;
    }),
    DEPOSIT("deposit",i->{
        AccountController.getInstance().deposit(i);
        return true;
    }),
    WITHDRAW("withdraw",i->{
        AccountController.getInstance().withdraw(i);
        return true;
    }),
    BALANCE("Balance",i->{
        AccountController.getInstance().getBalance(i);
        return true;
    }),
    DELETE("delete",i->{
        AccountController.getInstance().cancelAccount(i);
        return true;
    }),
    GETACCOUNT("getAccount",i->{
        AccountController.getInstance().getAccount();
        return true;
    })
    ;

    private final String aaname;
    private final Predicate<Scanner> predi;

    AccountRouter(String aaname, Predicate<Scanner> predi) {
        this.aaname = aaname;
        this.predi = predi;
    }

    public static Boolean getAccoRouter(Scanner sc) {
        String select = sc.next();
        System.out.println("\nwellcome to bank system.");
        System.out.println("'exit'back menu, createAccount, deposit, withdraw, " +
                "check the 'Balance', 'delete' Account, 'getAccount'check the my Account info");
        return Stream.of(AccountRouter.values())
                .filter(i->i.aaname.equals(select))
                .findAny().orElse(AccountRouter.EXIT)
                .predi.test(sc);
    }
}
