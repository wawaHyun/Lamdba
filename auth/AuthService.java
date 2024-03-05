
package auth;

import account.Account;
import member.Member;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public interface AuthService {
    String login(Member memberParam);
    String updatePassword(Member user);
    List<Member> findUsersByName(Member name);
    Map<String,?> findUsersByNemeFramMap(String name);
    List<?> findUsersByJob(String userJob);
    Map<String, ?> findUsersByJobFromMap(String job);
    String addUsers();
    Map<String, ?> getUserMap();
}