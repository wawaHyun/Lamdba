import account.AccountView;
import User.UserView;

import article.ArticleView;
import board.BoardView;
import crawler.CrawlerView;
import product.ProductView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("0-system exit, 1-User auth, 2-product, " +
                "3-board, 4-bank program, 5-crawler, 6-Article");
        while (true){
            switch (sc.next()){
                case "0" :
                    return;
                case "1" :
                    UserView.userMain(sc);
                    break;
                case "2" :
                    ProductView.main();
                    break;
                case "3" :
                    BoardView.boMain();
                    break;
                case "4" :
                    AccountView.accountMain(sc);
                    break;
                case "5" :
                    CrawlerView.crawlerMain(sc);
                    break;
                case "6" :
                    ArticleView.artiMain(sc);
                    break;

            }
        }

    }
}