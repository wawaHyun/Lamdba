
package com.turing.api.account;

import com.turing.api.enums.AccountRouter;

import java.util.Scanner;

public class AccountView {
    public static Boolean getAccMain(Scanner sc){
        return AccountRouter.getAccoRouter(sc);
    }
    public static void accountMain(Scanner sc) {
        while (getAccMain(sc).equals(true)) {
        }
    }
}