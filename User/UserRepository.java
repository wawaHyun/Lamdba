package User;

import article.Article;
import com.sun.source.tree.WhileLoopTree;
import member.Member;

import java.awt.geom.Arc2D;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        PreparedStatement prstmt = connection.prepareStatement(sql);
        ResultSet rs = prstmt.executeQuery();

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

        rs.close();
        prstmt.close();
        return null;
    }

    public String touch() {
        String cresql = "CREATE TABLE users(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, mem_id VARCHAR(20) NOT NULL,mem_pw VARCHAR(20) NOT NULL," +
                "name VARCHAR(20) NOT NULL, phone VARCHAR(20), job VARCHAR(20)," +
                "height VARCHAR(20), weight VARCHAR(20))";

        try {
            PreparedStatement prstmt = connection.prepareStatement(cresql);
            prstmt.execute(cresql);
            System.out.println("CREATE table done.");
            prstmt.close();
        } catch (Exception e) {
            System.out.println("that table is alreay contain.");
        }

        return null;
    }

    public String rm() {
        try {
            String dpsql = "DROP TABLE users;";
            System.out.println("DROP table done.");
            PreparedStatement pstmt = connection.prepareStatement(dpsql);
            pstmt.executeUpdate(dpsql);
            pstmt.close();
        } catch (Exception e) {
            System.out.println("data is notings");
        }

        return null;
    }

    public String ls() throws SQLException {
        String msg ="";
        List<Member> list = new ArrayList<>();
        String sql = "select * from Users";
        PreparedStatement prstmt = connection.prepareStatement(sql);
        ResultSet rs = prstmt.executeQuery();

            if(rs.next()){
                do{
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
                }while (rs.next());
            }else {
               msg = "no data";
            }
        return msg;
    }

    public String tain(Member mems) {
        String msg = "";
        try {
            String input = "INSERT INTO users (mem_id, mem_pw, name, phone, job, height, weight) " +
                    "VALUES (?,?,?,?,?,?,?)";

//            String input = "INSERT INTO users (" +
//                    "mem_id, mem_pw, name, phone, job, height, weight)" +
//                    "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement prstmt = connection.prepareStatement(input);

            prstmt.setString(1,mems.getMemId());
            prstmt.setString(2,mems.getMemPw());
            prstmt.setString(3,mems.getName());
            prstmt.setString(4,mems.getPhone());
            prstmt.setString(5,mems.getJob());
            prstmt.setString(6,String.valueOf(mems.getHeight()));
            prstmt.setString(7,String.valueOf(mems.getWeight()));

            prstmt.executeUpdate();

            System.out.println(mems.toString());
            msg = "INSERT success";
            prstmt.close();
        } catch (Exception e) {
            msg = "INSERT fail...";
        }
        return msg;
    }

}