
package com.turing.api.User;

import com.turing.api.enums.Messenger;
import com.turing.api.member.Member;

import java.sql.SQLException;
import java.util.*;

public class UserController {
    UserServiceImpl auth;

    private static UserController instance = new UserController();

    public UserController() {
        this.auth = UserServiceImpl.getInstance();
    }

    public static UserController getInstance() {
        return instance;
    }

    public Messenger save(Scanner sc) throws SQLException {
        System.out.println("Please enter information below in order.");
        System.out.println("ID, PW, name, phoneNum, job, height, weight");
        System.out.println("jaja 998 jainname 010555 OLdesu 180.0 70.0");

        return auth.save(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(sc.nextDouble())
                .weight(sc.nextDouble())
                .build());
    }

    public List<Member> findAll() throws SQLException {
        return auth.findAll();
    }

    public String login(Scanner sc) throws SQLException {
        System.out.println("Please enter your ID & PW.");
        return auth.login(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .build());
    }

    public Optional<Member> findById(Scanner sc) throws SQLException {
        System.out.println("Please enter Long ID you want to search for.");
        return auth.findById(sc.nextLong());
    }

    public Messenger updatePassword(Scanner sc) throws SQLException {
        System.out.println("Start update for password.\n" +
                "Please enter your ID & PW & reconfirm Pw.");
        return auth.updatePassword(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .memPwRe(sc.next())
                .build());
    }

    public Messenger delete(Scanner sc) throws SQLException {
        System.out.println("Please enter you want dalete memid & mempw.");
        return auth.delete(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .build());
    }

    public Boolean existsById(Scanner sc) {
        return auth.existsById(sc.nextLong());
    }

    public List<?> findUsersByJob(Scanner sc) {
        System.out.println("Please enter the job you wish to search for.");
        return auth.findUsersByJob(sc.next());
    }

    public Map<String, ?> findUsersByJobFromMap(Scanner sc) {
        System.out.println("Please enter the job you wish to search for.");
        return auth.findUsersByJobFromMap(sc.next());
    }

    public List<Member> findUsersByName(Scanner sc) {
        System.out.println("Please enter the name you wish to search for.");
        return auth.findUsersByName(Member.builder()
                .name(sc.next())
                .build());
    }

    public Map<String, ?> findUsersByNameFromMap(Scanner sc) {
        System.out.println("Please enter the name you wish to search for.");
        return auth.findUsersByNemeFramMap(sc.next());
    }

    public String count() {
        return auth.count();
    }

    public String addUsers() {
        return auth.addUsers();
    }

    public Optional<Member> getOne(Scanner sc) {
        return auth.getOne(sc.next());
    }

    public Map<String, ?> getUserMap() {
        return auth.getUserMap();
    }

    public String test() {
        return auth.test();
    }

    public List<?> findUsers() throws SQLException {
        return auth.findUsers();
    }

    public Messenger touch() {
        return auth.touch();
    }

    public Messenger rm() {
        return auth.rm();
    }

    public Messenger tain(Scanner sc) throws SQLException {
        System.out.println("Please enter information below in order.");
        System.out.println("ID, PW, name, phoneNum, job, height, weight");
        System.out.println("jaja 998 jainname 010555 jobjob 180 70");

        return auth.tain(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(sc.nextDouble())
                .weight(sc.nextDouble())
                .build());
    }

    public Messenger ls() throws SQLException {
        return auth.ls();
    }
}