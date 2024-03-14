
package com.turing.api.board;

import com.turing.api.common.UtilService;
import com.turing.api.common.UtilServiceImpl;
import com.turing.api.enums.ArticleRouter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static boolean getBoMain(Scanner sc) {
        return ArticleRouter.getArtiRouter(sc);
    }
    public static void boMain() {

    }
}