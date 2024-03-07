package User;

import com.sun.source.tree.WhileLoopTree;
import member.Member;

import java.sql.*;
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
        PreparedStatement prstmt =connection.prepareStatement(sql);
        ResultSet rs = prstmt.executeQuery();

        if(rs.next()){
            do{
                System.out.printf("ID : %d, Title : %s, content : %s, writer : %s\n"
                        ,rs.getInt("id")
                        ,rs.getString("title")
                        ,rs.getString("content")
                        ,rs.getString("writer"));
            }while (rs.next());
        }else {
            System.out.println("data is notings.");
        }

        rs.close();
        prstmt.close();

        return null;
    }
}