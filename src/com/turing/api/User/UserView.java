//
//package com.turing.api.User;
//
//import com.turing.api.enums.Navigation;
//import com.turing.api.enums.UserRouter;
//
//import java.sql.SQLException;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class UserView {
//    public static Boolean getUserMain(Scanner sc) {
//        return UserRouter.getUserRouter(sc);
//    }
//
//    public static void userMain(Scanner sc) {
//        UserController.getInstance().addUsers();
//
//        while (getUserMain(sc).equals(true)) {
//            System.out.println(" ");
//        }
//    }
//}
