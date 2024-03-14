package com.turing.api;

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
    public static Boolean getMain(Scanner sc){
        return Navigation.getNavigation(sc);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (getMain(sc).equals(true)){
            System.out.println(Main.getMain(sc));
        }

    }
}