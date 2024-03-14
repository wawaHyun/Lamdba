package com.turing.api.strategy;

import java.util.Scanner;

public class Weekend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String day = "";
        while (!day.equals("x")) {
            day = WeekendStrategy.execute(sc);
            System.out.println("strategy result : " + day);
        }

    }

//    private static void execute(Scanner sc) {
//        System.out.println("x is exit, input 1~7 : ");
//        String day = sc.next();
//        String res = "";
//        switch (day) {
//            case "1":
//                res = "Monday";
//                break;
//            case "2":
//                res = "Tuesday";
//                break;
//            case "3":
//                res = "Wednesday";
//                break;
//            case "4":
//                res = "Thursday";
//                break;
//            case "5":
//                res = "Friday";
//                break;
//            case "6":
//                res = "Saturday";
//                break;
//            case "7":
//                res = "Sunday";
//                break;
//            default:
//                System.out.println("wrong");
//                return;
//        }
//        System.out.println(day);
//    }
}

    
