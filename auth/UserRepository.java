<<<<<<< HEAD
package auth;
import java.sql.*;
public class UserRepository {


    public void addUsers() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/turingdb";
        String userName = "root";
        String password = "password";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
=======
package auth;

public class UserRepository {


    public void addUsers() {
    }
>>>>>>> 1d5e23b5330aae36283c381fc0ae287c6bdf79dd
}