package com.turing.api.enums;

import com.turing.api.Menu.Menu;
import com.turing.api.Menu.MenuController;
import com.turing.api.User.UserController;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("x",i->{
        System.out.println("back menu.");
        return false;
    }),
    JOIN("joi",i->{
        try {
            System.out.println(UserController.getInstance().save(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    LOGIN("log",i->{
        try {
            System.out.println(UserController.getInstance().login(i));;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    FINDBYID("cat",i->{
        try {
            UserController.getInstance().findById(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    PWUPDATE("ch-pw",i->{
        UserController.getInstance().updatePassword(i);
        return true;
    }),
    DELETE("rm",i->{
        UserController.getInstance().delete(i);
        return true;
    }),
    FINDALL("ls-a",i->{
        UserController.getInstance().findAll().forEach(System.out::println);
        return true;
    }),
    COUNT("cnt",i->{
        System.out.print("total of number is");
        UserController.getInstance().count();
        return true;
    }),
    FINDUSERSBYNAME("ls-n",i->{
        UserController.getInstance().findUsersByName(i).forEach(System.out::println);
        return true;
    }),
    FINDUSERSBYNAMEFROMMAP("findUsersByNameFromMap",i->{
//        UserController.getInstance().findUsersByNameFromMap(i).forEach(i-> i.toCharArray());
        return true;
    }),
    FINDUSERSBYJOB("ls-job",i->{
        UserController.getInstance().findUsersByJob(i).forEach(System.out::println);
        return true;
    }),
    FINDUSERSBYJOBFROMMAP("findUsersByJobFromMap",i->{
//        UserController.getInstance().findUsersByNameFromMap(i).forEach(System.out::println);
        return true;
    }),
    GETONE("getOne",i->{
        UserController.getInstance().getOne(i);
        return true;
    }),
    GETUSERMAP("getUserMap",i->{
        UserController.getInstance().getUserMap();
        return true;
    }),
    EXISTSBYID("existsById",i->{
        UserController.getInstance().existsById(i);
        return true;
    }),
    TEST("test",i->{
        UserController.getInstance().test();
        return true;
    }),
    FINDUSERS("findUsers",i->{
        try {
            UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    TOUCH("touch",i->{
        System.out.println(UserController.getInstance().touch());;
        return true;
    }),
    RM("rm",i->{
        System.out.println(UserController.getInstance().rm());
        return true;
    }),
    LS("ls",i->{
        try {
            UserController.getInstance().ls();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    IN("in",i->{
        try {
            System.out.println(UserController.getInstance().tain(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    })

;
    private final String name;
    private final Predicate<Scanner> predi;

    UserRouter(String name, Predicate<Scanner> predi) {
        this.name = name;
        this.predi = predi;
    }

    public static Boolean getUserRouter(Scanner sc) {
//        System.out.println("'exit'back main menu, 'join'(save), login, Long id search('findById'), " +
//                "pwUpdate, member 'delete', member list('findAll'), 'count'member total of number, " +
//                "NL name search(findUsersByName), NL name search(findUsersByNameFromMap)," +
//                "job search(findUsersByJob), job search(findUsersByJobFromMap), getOne(String id)," +
//                "getUserMap, Check membership registration('existsById'), test, Repository, " +
//                "touch-table create, rm-table delete, ls-table list check, in-table value insert");

        System.out.println("[MENU]");
        MenuController.getInsteance().getMenusByCategory("user").forEach(i -> System.out.print(((Menu)i).getMenuItem() + ", "));
        System.out.println();
        String select = sc.next();
        return Stream.of(UserRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(UserRouter.EXIT)
                .predi.test(sc);
    }

}
