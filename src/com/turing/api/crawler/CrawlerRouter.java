package com.turing.api.crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CrawlerRouter {
    EXIT("exit",i->{
        System.out.println("back menu.");
        return false;
    }),
    BUGS("bugs",i->{
        System.out.println("bugs Music");
        Map<String, ?> map = null;
        try {
            map = CrawlerController.getInstance().findBugsMusic(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<Element> rank = (Iterator<Element>) map.get("rank");
        Iterator<Element> artist = (Iterator<Element>) map.get("artist");
        Iterator<Element> title = (Iterator<Element>) map.get("title");

        while (rank.hasNext()){
            System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
        }
        return true;
    }),
    MELON("melon",i->{
        System.out.println("melon Music");
        Map<String, ?> map2 = null;
        try {
            map2 = CrawlerController.getInstance().findMelonMusic(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<Element> rank2 = (Iterator<Element>) map2.get("rank");
        Iterator<Element> artist2 = (Iterator<Element>) map2.get("artist");
        Iterator<Element> title2 = (Iterator<Element>) map2.get("title");

        while (rank2.hasNext()){
            System.out.println(rank2.next().text() + "위 " + artist2.next().text() + " - " + title2.next().text());
        }
        return true;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predi;

    CrawlerRouter(String aaname, Predicate<Scanner> predi) {
        this.name = aaname;
        this.predi = predi;
    }

    public static Boolean getCrawRouter(Scanner sc) {
        String select = sc.next();
        System.out.println("'exit'back menu, 'bugs' Music, 'melon' Music,");
        return Stream.of(CrawlerRouter.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(CrawlerRouter.EXIT)
                .predi.test(sc);
    }
}
