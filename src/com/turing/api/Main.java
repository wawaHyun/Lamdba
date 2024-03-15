package com.turing.api;

import com.turing.api.Menu.Menu;
import com.turing.api.Menu.MenuController;
import com.turing.api.enums.MenuRouter;
import com.turing.api.enums.Messenger;
import com.turing.api.enums.NavigationOfSupplier;
import com.turing.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static Boolean getMain(Scanner sc){
//        return NavigationOfPredicate.getNavigation(sc);
//    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true){
        UserRouter.getUserRouter(sc);}
//        MenuRouter.getMenuRouter(sc);

//        Messenger msg = MenuController.getInsteance().returnMessenger();
//        Menu oneMenu = MenuController.getInsteance().returnMenu();
//        List<?> allMenu = MenuController.getInsteance().returnAllMenu();

        //-------------------------------------------------------------
//        String stringFlag = "";
//        while (!stringFlag.equals("exit")) {
//            stringFlag = NavigationOfSupplier.getNavigation();
//            System.out.println("NavigationOfSupplier : "+stringFlag);
//        }

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

//        System.exit(0);

    }
}