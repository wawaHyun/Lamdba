package com.turing.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1",i->"Monday"),
    Tuesday("2",i->"Tuesday"),
    Wednesday("3",i->"Wednesday"),
    Thursday("4",i->"Thursday"),
    Friday("5",i->"Friday"),
    Saturday("6",i->"Saturday"),
    Sunday("7",i->"Sunday"),
    Wrong("x",i->{
        System.out.println("Wrong input,");
        System.out.println("System Down, System Down..!");
        System.exit(0);
        return "";
    })
    ;

    private final String name;
    private final Function<String,String> func;

    WeekendStrategy(String name, Function<String, String> func) {
        this.name = name;
        this.func = func;
    }

    public static String execute(Scanner sc) {
        System.out.println("x is exit, input 1~7 : ");
        String select = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(select))
                .findAny().orElseGet(()->Wrong)
                .func.apply(select);
    }
}
