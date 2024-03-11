package com.turing.api.crawler;

import common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.*;

public class CrawlerRepository extends AbstractRepository {

    private static CrawlerRepository instance = new CrawlerRepository();
    private Map<String, ?> map;

    private CrawlerRepository() {
        this.map = new HashMap<>();
    }

    public static CrawlerRepository getInstance() {
        return instance;
    }


    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Map<String, Iterator> localmap = new HashMap<>();

        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart")
                .timeout(10 * 1000).get();
        Elements elems = doc.select("tbody");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("strong").iterator();

        System.out.println("벅스뮤직 결과");
        localmap.put("rank", rank);
        localmap.put("title", title);
        localmap.put("artist", artist);
        map = localmap;

        return map;
    }

    public Map<String, ?> save2(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm")
                .timeout(10 * 1000).get();
        Elements elems = doc.select("tbody");
        Iterator<Element> title = elems.select("div.ellipsis.rank01").iterator();
        Iterator<Element> artist = elems.select("div.ellipsis.rank02").iterator();
        Iterator<Element> rank = elems.select("span.rank").iterator();

        System.out.println("멜론뮤직 결과");
        Map<String, Iterator> localmap = new HashMap<>();
        localmap.put("rank", rank);
        localmap.put("title", title);
        localmap.put("artist", artist);

        map = localmap;
        return map;
    }
}