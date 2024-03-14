package com.turing.api.enums;

import com.turing.api.User.UserController;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("exit",i->{
        System.out.println("back menu.");
        return false;
    }),
    JOIN("join",i->{
        System.out.println(UserController.getInstance().save(i));
        return true;
    }),
    LOGIN("login",i->{
        UserController.getInstance().login(i);
        return true;
    }),
    FINDBYID("findById",i->{
        UserController.getInstance().findById(i);
        return true;
    }),
    PWUPDATE("pwUpdate",i->{
        UserController.getInstance().updatePassword(i);
        return true;
    }),
    DELETE("delete",i->{
        UserController.getInstance().delete(i);
        return true;
    }),
    FINDALL("findAll",i->{
        UserController.getInstance().findAll().forEach(System.out::println);
        return true;
    }),
    COUNT("count",i->{
        System.out.print("total of number is");
        UserController.getInstance().count();
        return true;
    }),
    FINDUSERSBYNAME("findUsersByName",i->{
        UserController.getInstance().findUsersByName(i).forEach(System.out::println);
        return true;
    }),
    FINDUSERSBYNAMEFROMMAP("findUsersByNameFromMap",i->{
//        UserController.getInstance().findUsersByNameFromMap(i).forEach(i-> i.toCharArray());
        return true;
    }),
    FINDUSERSBYJOB("findUsersByJob",i->{
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
        System.out.println("'exit'back main menu, 'join'(save), login, Long id search('findById'), " +
                "pwUpdate, member 'delete', member list('findAll'), 'count'member total of number, " +
                "NL name search(findUsersByName), NL name search(findUsersByNameFromMap)," +
                "job search(findUsersByJob), job search(findUsersByJobFromMap), getOne(String id)," +
                "getUserMap, Check membership registration('existsById'), test, Repository, " +
                "touch-table create, rm-table delete, ls-table list check, in-table value insert");
        String select = sc.next();
        return Stream.of(UserRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(UserRouter.EXIT)
                .predi.test(sc);
    }

}
