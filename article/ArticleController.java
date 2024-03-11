<<<<<<< HEAD
package article;

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
=======
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
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
