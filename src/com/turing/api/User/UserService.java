
package com.turing.api.User;

import com.turing.api.enums.Messenger;
import com.turing.api.member.Member;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    String login(Member memberParam) throws SQLException;
    Messenger updatePassword(Member user) throws SQLException;
    List<Member> findUsersByName(Member name);
    Map<String,?> findUsersByNemeFramMap(String name);
    List<?> findUsersByJob(String userJob);
    Map<String, ?> findUsersByJobFromMap(String job);
    String addUsers();
    Map<String, ?> getUserMap();
    String test();
    List<?> findUsers() throws SQLException;
    Messenger touch() ;
    Messenger rm() ;
    Messenger tain(Member mems) throws SQLException;
    Messenger ls() throws SQLException;
}