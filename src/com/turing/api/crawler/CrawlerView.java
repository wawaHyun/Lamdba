
package  com.turing.api.crawler;

import  com.turing.api.account.AccountView;
import  com.turing.api.board.BoardView;
import  com.turing.api.product.ProductView;

import org.jsoup.Jsoup;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import org.jsoup.nodes.Element;

public class CrawlerView {
    public static void crawlerMain(Scanner sc) throws IOException {
        CrawlerController craw = new CrawlerController();

        System.out.println("0-system exit, 1-bugs Music, 2-melon Music, " +
                "3-, 4-");
        while (true){
            switch (sc.next()){
                case "0" :
                    return;
                case "1" :
                    System.out.println("bugs Music");
                    Map<String, ?> map = craw.findBugsMusic(sc);
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> title = (Iterator<Element>) map.get("title");

                    while (rank.hasNext()){
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;

                case "2" :
                    System.out.println("melon Music");
                    Map<String, ?> map2 = craw.findMelonMusic(sc);
                    Iterator<Element> rank2 = (Iterator<Element>) map2.get("rank");
                    Iterator<Element> artist2 = (Iterator<Element>) map2.get("artist");
                    Iterator<Element> title2 = (Iterator<Element>) map2.get("title");

                    while (rank2.hasNext()){
                        System.out.println(rank2.next().text() + "위 " + artist2.next().text() + " - " + title2.next().text());
                    }
                    break;

            }
        }

    }
}
