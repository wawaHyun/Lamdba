<<<<<<< HEAD
package crawler;

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
=======
package crawler;

import account.AccountServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
