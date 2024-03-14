package com.turing.api;

import com.turing.api.Menu.MenuController;
import com.turing.api.enums.NavigationOfSupplier;

import java.util.Scanner;

public class Main {
//    public static Boolean getMain(Scanner sc){
//        return NavigationOfPredicate.getNavigation(sc);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //-------------------------------------------------------------
        String stringFlag = "";
        while (!stringFlag.equals("exit")) {
            stringFlag = NavigationOfSupplier.getNavigation();
            System.out.println("NavigationOfSupplier : "+stringFlag);
        }

//        //-------------------------------------------------------------
//        String stringFlag = "";
//        while (!stringFlag.equals("exit")) {
//            stringFlag = NavigationOfFunction.getNavigation(sc);
//            System.out.println("NavigationOfFunction : " + stringFlag);
//        }

        //-------------------------------------------------------------
//            NavigationOfConsumer.getNavigation(sc);
//        System.out.println("NavigationOfConsumer is done.");


//        //-------------------------------------------------------------
//        boolean booleanFlag = true;
//        while (booleanFlag==true) {
//            booleanFlag = NavigationOfPredicate.getNavigation(sc);
//            System.out.println("NavigationOfPredicate : " + booleanFlag);
//        }

        System.exit(0);

    }
}