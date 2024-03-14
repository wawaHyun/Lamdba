
package com.turing.api.account;

import com.turing.api.common.UtilService;
import com.turing.api.common.UtilServiceImpl;
import com.turing.api.enums.Messenger;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

public class AccountController {
    AccountServiceImpl accSer;
    LocalDate nowDate;
    UtilService util;
private static AccountController instance = new AccountController();

    public static AccountController getInstance() {
        return instance;
    }

    public AccountController() {
        this.accSer = AccountServiceImpl.getInstance();
        this.nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
        this.util = UtilServiceImpl.getInstance();
    }

    public Messenger createAccount(Scanner sc) {
        System.out.println("Start creating your com.turing.api.account.");
        System.out.println("Please enter the com.turing.api.account holder.");
        return accSer.save(Account.builder()
                .accountNumber(util.createRandomAccount())
                .accountHolder(sc.next())
                .balance(0)
                .transactionDate(nowDate)
                .build());
    }

    public String deposit(Scanner sc) {
        System.out.println("Start deposit.\n" +
                "Please enter your com.turing.api.account & holer & you want deposit.");
        return accSer.deposit(Account.builder()
                .transactionDate(nowDate)
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .money(sc.nextInt())
                .build());
    }

    public String withdraw(Scanner sc) {
        System.out.println("Start withdraw.\n" +
                "Please enter your com.turing.api.account & holer & you want withdraw.");
        return accSer.deposit(Account.builder()
                .transactionDate(nowDate)
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .money(sc.nextInt())
                .build());
    }

    public String getBalance(Scanner sc) {
        System.out.println("Enter the com.turing.api.account whose balance you want to check.");
        return accSer.getBalance(Account.builder()
                .accountNumber(sc.next())
                .transactionDate(nowDate)
                .build());
    }

    public Messenger cancelAccount(Scanner sc) {
        System.out.println("Start deleting your com.turing.api.account.");
        System.out.println("Please enter the Account & holder.");
        return accSer.delete(Account.builder()
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .transactionDate(nowDate)
                .build());
    }

    public String getAccount() {
        return accSer.count();
    }



}