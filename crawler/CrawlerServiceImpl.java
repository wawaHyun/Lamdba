
package com.turing.api.crawler;

import java.io.IOException;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService{
    private CrawlerRepository repository;
    private static CrawlerServiceImpl instance= new CrawlerServiceImpl();;
    private CrawlerServiceImpl() {
        this.repository = CrawlerRepository.getInstance();
    }
    public static CrawlerServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Map<String, ?> findNamesFromWeb(Map<String, ?> paramMap) throws IOException {
        return repository.save(paramMap);
    }

    @Override
    public Map<String, ?> findNamesFromWeb2(Map<String, ?> paramMap) throws IOException {
        return repository.save2(paramMap);
    }
}

