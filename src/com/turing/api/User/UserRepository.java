
package com.turing.api.User;

import com.turing.api.enums.NavigationOfSupplier;
import com.turing.api.enums.UserRouter;
import com.turing.api.member.Member;
import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection;
    PreparedStatement prstmt;
    ResultSet rs;
    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
    }
    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository connecting test.";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from com.turing.api.board";
        prstmt = connection.prepareStatement(sql);
        rs = prstmt.executeQuery();

        String msg = "";
        if (rs.next()) {
            do {
                System.out.printf("ID : %d, Title : %s, content : %s, writer : %s\n"
                        , rs.getInt("id")
                        , rs.getString("title")
                        , rs.getString("content")
                        , rs.getString("writer"));
            } while (rs.next());
        } else {
            System.out.println("data is notings.");
        }

        return null;
    }

    public Messenger touch() {
        String cresql = "CREATE TABLE users(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, mem_id VARCHAR(20) NOT NULL,mem_pw VARCHAR(20) NOT NULL," +
                "name VARCHAR(20) NOT NULL, phone VARCHAR(20), job VARCHAR(20)," +
                "height VARCHAR(20), weight VARCHAR(20))";
        try {
            prstmt = connection.prepareStatement(cresql);
            prstmt.execute(cresql);
            System.out.println("생성완");
        } catch (Exception e) {
            System.out.println("문제 발생");
            cresql = "";
        }
        return (cresql.isEmpty()) ? Messenger.FAIL : Messenger.SUCCESS;
    }

    public Messenger rm() {
        String dpsql = "DROP TABLE users";
        try{
            prstmt = connection.prepareStatement(dpsql);
            prstmt.executeUpdate(dpsql);
        }catch (Exception e){
            dpsql = "";
        }

        return (dpsql.isEmpty()) ? Messenger.FAIL : Messenger.SUCCESS;
    }

    public Messenger ls() throws SQLException {
        List<Member> list = new ArrayList<>();

        String sql = "select * from Users";

        Messenger msg = Messenger.SUCCESS;

        try {
            prstmt = connection.prepareStatement(sql);
            rs = prstmt.executeQuery();
                list.add(Member.builder()
                        .id(rs.getLong(1))
                        .memId(rs.getString(2))
                        .memPw(rs.getString(3))
                        .name(rs.getString(4))
                        .phone(rs.getString(5))
                        .job(rs.getString(6))
                        .height(Double.parseDouble(rs.getString(7)))
                        .weight(Double.parseDouble(rs.getString(8)))
                        .build());

                list.forEach(System.out::println);
        }catch (Exception e){
            msg = Messenger.FAIL;
            System.out.println("table is nothing.");
            System.out.println("back to first menu.");
            NavigationOfSupplier.getNavigation();
        }

        return msg;
    }

    public Messenger tain(Member mems) throws SQLException {
        String msg = "";
            String input = "INSERT INTO users (mem_id, mem_pw, name, phone, job, height, weight) " +
                    "VALUES (?,?,?,?,?,?,?)";
            prstmt = connection.prepareStatement(input);

            prstmt.setString(1,mems.getMemId());
            prstmt.setString(2,mems.getMemPw());
            prstmt.setString(3,mems.getName());
            prstmt.setString(4,mems.getPhone());
            prstmt.setString(5,mems.getJob());
            prstmt.setString(6,String.valueOf(mems.getHeight()));
            prstmt.setString(7,String.valueOf(mems.getWeight()));
            System.out.println(mems.toString());
        return (prstmt.executeUpdate()>0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

}