package com.turing.api.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String,?> findNamesFromWeb(Map<String,?> paramMap) throws IOException;
    Map<String,?> findNamesFromWeb2(Map<String,?> paramMap) throws IOException;

}