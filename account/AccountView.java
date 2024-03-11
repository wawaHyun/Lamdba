
package com.turing.api.account;

import java.util.Scanner;

public class AccountView {
    public static void accountMain(Scanner sc) {
        AccountController accConl = new AccountController();

        while (true){
            System.out.println("\nwellcome to bank system.");
            System.out.println("0-back menu, 1-createAccount, 2-deposit, 3-withdraw, " +
                    "4-check the Balance, 5-delete Account, 6-check the my Account info");
            switch (sc.next()) {
            case "0":
                return;
            case "1":
                //ok
//                accConl.createAccount(sc);
                break;
            case "2":
                System.out.println(accConl.deposit(sc));
                break;
            case "3":
                System.out.println(accConl.withdraw(sc));
                break;
            case "4":
                //ok
                System.out.println(accConl.getBalance(sc));
                break;
            case "5":
//                accConl.cancelAccount(sc);
                break;
            case "6":
                //ok
//                accConl.getAccount();
                break;
        }}
    }
}