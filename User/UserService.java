
package User;

<<<<<<< HEAD
import enums.Messenger;
=======
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
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

<<<<<<< HEAD
    Messenger touch() throws SQLException;
=======
    String touch() throws SQLException;
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9

    String rm() throws SQLException;

    String ls() throws SQLException;

    String tain(Member mems);
}