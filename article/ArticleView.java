
package com.turing.api.article;

import com.turing.api.enums.ArticleRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static Boolean getArtiMain(Scanner sc){
        return ArticleRouter.getArtiRouter(sc);
    }
    public static void artiMain(Scanner sc) {
        while (getArtiMain(sc).equals(true)) {
        }
    }
}