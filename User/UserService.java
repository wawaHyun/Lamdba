
package User;

import enums.Messenger;
import member.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    String login(Member memberParam);
    String updatePassword(Member user);
    List<Member> findUsersByName(Member name);
    Map<String,?> findUsersByNemeFramMap(String name);
    List<?> findUsersByJob(String userJob);
    Map<String, ?> findUsersByJobFromMap(String job);
    String addUsers();
    Map<String, ?> getUserMap();
    String test();
    List<?> findUsers() throws SQLException;
    Messenger touch();

    String rm();

    String tain(Member mems);

    String ls() throws SQLException;
}