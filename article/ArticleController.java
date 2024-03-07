package article;

import crawler.CrawlerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    ArticleService artSer;
    public ArticleController(){
        this.artSer = ArticleServiceImpl.getInstance();
    }
    public List<?> findArticleByWeb() throws SQLException {
        return artSer.findArticleByWeb();
    }
}
