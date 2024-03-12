
package com.turing.api.crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.turing.api.enums.CrawlerRouter;
import org.jsoup.nodes.Element;

public class CrawlerView {
    public static Boolean getCrawlerMain(Scanner sc){
        return CrawlerRouter.getCrawRouter(sc);
    }
    public static void crawlerMain(Scanner sc) throws IOException {

        while (getCrawlerMain(sc).equals(true)){}

    }
}

