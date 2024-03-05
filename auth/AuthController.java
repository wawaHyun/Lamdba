
package auth;
import account.Account;
import enums.Messenger;
import member.Member;
import auth.AuthService;
import auth.AuthServiceImpl;

import java.util.*;

public class AuthController {
    AuthServiceImpl auth;

    public AuthController() {
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
                .memberId(sc.next())
                .memberPw(sc.next())
                .build());
    }

    public Optional<Member> findById(Scanner sc) {
        return auth.findById(sc.nextLong());
    }

    public String updatePassword(Scanner sc) {
        System.out.println("Please enter your ID & PW.");
        return auth.updatePassword(Member.builder()
                .memberId(sc.next())
                .memberPw(sc.next())
                .build());
    }

    public String delete(Scanner sc) {
        return auth.delete(Member.builder()
                .memberId(sc.next())
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

}