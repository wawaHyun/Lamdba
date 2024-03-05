package crawler;

import account.AccountView;
import auth.AuthView;
import board.BoardView;
import product.ProductView;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void crawlerMain(Scanner sc){
        CrawlerController craw = new CrawlerController();


        System.out.println("0-system exit, 1-bugs Music, 2-, " +
                "3-, 4-");
        while (true){
            switch (sc.next()){
                case "0" :
                    return;
                case "1" :
                    System.out.println("bugs Music");
                    Map<String,?> map = craw.findByMusic(sc);
                    craw.findByMusic(sc);
                    break;

            }
        }

    }
}
