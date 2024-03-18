
package com.turing.api.User;

import com.turing.api.enums.NavigationOfSupplier;
import com.turing.api.enums.UserRouter;
import com.turing.api.member.Member;
import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    private UserRepository() throws SQLException {
        conn = DriverManager.getConnection(
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
        String sql = "select * from board";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

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
            pstmt = conn.prepareStatement(cresql);
            pstmt.execute(cresql);
            System.out.println("생성완");
        } catch (Exception e) {
            System.out.println("문제 발생");
            cresql = "";
        }
        return (cresql.isEmpty()) ? Messenger.FAIL : Messenger.SUCCESS;
    }

    public Messenger rm() {
        String dpsql = "DROP TABLE users";
        try {
            pstmt = conn.prepareStatement(dpsql);
            pstmt.executeUpdate(dpsql);
        } catch (Exception e) {
            dpsql = "";
        }

        return (dpsql.isEmpty()) ? Messenger.FAIL : Messenger.SUCCESS;
    }

    public Messenger ls() throws SQLException {
        List<Member> list = new ArrayList<>();

        String sql = "select * from Users";

        Messenger msg = Messenger.SUCCESS;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
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
        } catch (Exception e) {
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
        pstmt = conn.prepareStatement(input);

        pstmt.setString(1, mems.getMemId());
        pstmt.setString(2, mems.getMemPw());
        pstmt.setString(3, mems.getName());
        pstmt.setString(4, mems.getPhone());
        pstmt.setString(5, mems.getJob());
        pstmt.setString(6, String.valueOf(mems.getHeight()));
        pstmt.setString(7, String.valueOf(mems.getWeight()));
        System.out.println(mems.toString());
        return (pstmt.executeUpdate() > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public List<String> login(Member member) throws SQLException {
        String sql = "select mem_id, mem_pw users from users " +
                "where mem_id=? OR mem_pw=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getMemId());
        pstmt.setString(2, member.getMemPw());
        rs = pstmt.executeQuery();
        List<String> list = new ArrayList<>();

        if (!rs.next()) {
            list.add(0, "wrong ID");
            list.add(1, "wrong PW");
            return list;
        }
        list.add(0, rs.getString("mem_id"));
        list.add(1, rs.getString(2));

        return list;
    }

    public Messenger findById(Long id) throws SQLException {
        String sql = "select id, mem_id from users where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, id);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            Member memids = Member.builder()
                    .id(rs.getLong("id"))
                    .memId(rs.getString("mem_id"))
                    .build();

            System.out.println("Long Id : " + rs.getString("id"));
            System.out.println("member id : " + rs.getString("mem_id"));
        } else {
            System.out.println("Long id " + id + " is nothing.");
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger updatePassword(Member member) throws SQLException {
        String sql = "update users set mem_pw = ? where mem_id = ?";
        System.out.println(member.getMemId() + " " + member.getMemPw());
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getMemPw());
        pstmt.setString(2, member.getMemId());
        pstmt.executeUpdate();
        return Messenger.SUCCESS;
    }


    public String delete(Member member) throws SQLException {
        String sql = "DELETE FROM users Where mem_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getMemId());
        pstmt.executeUpdate();
        return "deledele";
    }

    public List<Member> findAll() throws SQLException {
        String sql = "select mem_id, name, phone, job, height, weight from users";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<Member> list = new ArrayList<>();
        if(rs.next()) {
            list.add(Member.builder()
                    .memId(rs.getString(1))
                    .name(rs.getString(2))
                    .phone(rs.getString(3))
                    .job(rs.getString(4))
                    .height(rs.getDouble(5))
                    .weight(rs.getDouble(6))
                    .build());
        }
        return list;
    }
}
