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
            String sql = "select * from articles";
            PreparedStatement prstmt = conec.prepareStatement(sql);
            ResultSet rs = prstmt.executeQuery();

//            List<?> list = new ArrayList<>();
//            list.forEach(-> list.set(rs.getInt("id"),
//                    rs.getInt("title"),
//                    rs.getInt("content"),
//                    rs.getInt("writer")));


            List<Article> list = new ArrayList<>();
            if(rs.next()){
                do{
                    list.add(Article.builder()
                            .id(rs.getLong("id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .build());

//                    System.out.printf("ID : %d, Title : %s, content : %s, writer : %s\n",
//                            rs.getInt("id"),
//                            rs.getString("title"),
//                            rs.getString("content"),
//                            rs.getInt("writer"));
                }while (rs.next());
            }else {
                System.out.println("data is notings.");
            }

            rs.close();
            prstmt.close();
            System.out.println("kdjhf");

            return list;

        }


    }
