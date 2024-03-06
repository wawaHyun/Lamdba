import account.AccountView;
import auth.AuthView;
import board.BoardView;
import crawler.CrawlerService;
import crawler.CrawlerView;
import product.ProductView;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("0-system exit, 1-auth, 2-product, " +
                "3-board, 4-bank program, 5-crawler");
        while (true){
            switch (sc.next()){
                case "0" :
                    return;
                case "1" :
                    AuthView.authMain(sc);
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
            }
        }

    }
}