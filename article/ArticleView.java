package article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void artiMain(Scanner sc) throws SQLException {
        ArticleController ctrl = new ArticleController();

        while (true){
            System.out.println("\nwellcome to Articles.");
            System.out.println("0-back menu, 1-article");
            switch (sc.next()) {
                case "0":
                    return;
                case "1":
                    ctrl.findArticleByWeb().forEach(System.out::println);
                    break;

            }}

    }
}
