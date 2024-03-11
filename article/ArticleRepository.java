<<<<<<< HEAD
package article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

        private static ArticleRepository instance;

        static {
            try {
                instance = new ArticleRepository();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        Connection conec;
        private ArticleRepository() throws SQLException {
            this.conec = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/turingdb",
                    "turing",
                    "password");
        }
        public static ArticleRepository getInstance(){
            return instance;
        }


        public List<?> findArticleByWeb() throws SQLException {
            String sql = "select dfdfdfdf from article";
            PreparedStatement prstmt = conec.prepareStatement(sql);
            ResultSet rs = prstmt.executeQuery();

            List<Article> list = new ArrayList<>();
            if(rs.next()){
                do{
                    list.add(Article.builder()
                            .id(rs.getLong("id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .build());

                }while (rs.next());
            }else {
                System.out.println("data is notings.");
            }

            rs.close();
            prstmt.close();
            return list;

        }


    }
=======
package article;

import common.AbstractService;
import enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    public class ArticleRepository {

        private static ArticleRepository instance;

        static {
            try {
                instance = new ArticleRepository();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        Connection conec;
        private ArticleRepository() throws SQLException {
            this.conec = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/turingdb",
                    "turing",
                    "password");
        }
        public static ArticleRepository getInstance(){
            return instance;
        }


        public List<?> findArticleByWeb() throws SQLException {
            String sql = "select dfdfdfdf from article";
            PreparedStatement prstmt = conec.prepareStatement(sql);
            ResultSet rs = prstmt.executeQuery();

            List<Article> list = new ArrayList<>();
            if(rs.next()){
                do{
                    list.add(Article.builder()
                            .id(rs.getLong("id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .build());

                }while (rs.next());
            }else {
                System.out.println("data is notings.");
            }

            rs.close();
            prstmt.close();
            return list;

        }


    }
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
