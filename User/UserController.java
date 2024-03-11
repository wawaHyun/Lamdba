
package User;
import enums.Messenger;
import member.Member;

import java.sql.SQLException;
import java.util.*;

public class UserController {
    UserServiceImpl auth;

    public UserController() {
        this.auth = UserServiceImpl.getInstance();
    }

    public Messenger save() {
        System.out.println("Please enter information below in order.");
        System.out.println("ID, PW, name, socialNum, phoneNum, address, job, height, weight");
        System.out.println("jaja 998 jainname 00531 010555 adressUU OLdesu 180 70");

        return Messenger.SUCCESS;
    }

    public List<Member> findAll() {
        return auth.findAll();
    }

    public String login(Scanner sc) {
        System.out.println("Please enter your ID & PW.");
        return auth.login(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .build());
    }

    public Optional<Member> findById(Scanner sc) {
        return auth.findById(sc.nextLong());
    }

    public String updatePassword(Scanner sc) {
        System.out.println("Please enter your ID & PW.");
        return auth.updatePassword(Member.builder()
                .memId(sc.next())
                .memPw(sc.next())
                .build());
    }

    public String delete(Scanner sc) {
        return auth.delete(Member.builder()
                .memId(sc.next())
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
<<<<<<< HEAD
    public Messenger touch() throws SQLException {return auth.touch();}
=======
    public String touch() throws SQLException {return auth.touch();}
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9

    public String rm() throws SQLException {return auth.rm();
    }

    public String ls(Scanner sc) throws SQLException {
        return auth.ls();
    }

    public String tain(Scanner sc) {
        System.out.println("Plese enter your infomation");
        System.out.println("ID, PW, name, phoneNum, job, height, weight");
        System.out.println("jaja 998 jainname 010555 OLdesu 180 70");
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
}