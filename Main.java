package com.turing.api;

import com.turing.api.User.UserView;
import com.turing.api.account.AccountView;

import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.enums.Navigation;
import com.turing.api.product.ProductView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static String getMain(String select){
        return Navigation.getNavigation(select);
    }
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

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