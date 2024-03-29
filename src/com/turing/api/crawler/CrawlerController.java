
package  com.turing.api.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    CrawlerServiceImpl crawSer;

    private static CrawlerController instance = new CrawlerController();
    public CrawlerController() {
        this.crawSer = CrawlerServiceImpl.getInstance();
    }

    public static CrawlerController getInstance() {
        return instance;
    }

    public Map<String, ?> findBugsMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하세요");
        System.out.println("https://music.bugs.co.kr/chart");
        String url = sc.next();
        Map<String, String> paramap = new HashMap<>();
        paramap.put("URl", url);
        return crawSer.findNamesFromWeb(paramap);
    }

    public Map<String, ?> findMelonMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하세요");
        System.out.println("https://www.melon.com/chart/index.htm");
        String url = sc.next();
        Map<String, String> paramap = new HashMap<>();
        paramap.put("URl", url);
        return crawSer.findNamesFromWeb2(paramap);
    }
}

