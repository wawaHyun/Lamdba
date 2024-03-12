package com.turing.api.enums;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Navigation {
    ;
    private final String name;
    private final Predicate<String> predi;

    Navigation(String name, Predicate<String> predi) {
        this.name = name;
    }
    public static Navigation getNavigation(){
        System.out.println("0-system exit, 1-User auth, 2-product, " +
                "3-com.turing.api.board, 4-bank program, 5-crawler, 6-Article");
        return Arrays.stream(Navigation.values())
                .filter(o->o.)
    }

}
