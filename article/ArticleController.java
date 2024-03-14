
package com.turing.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private static ArticleController instance = new ArticleController();
    ArticleService artSer;
    public ArticleController(){
        this.artSer = ArticleServiceImpl.getInstance();
    }

    public static ArticleController getInstance() {
        return instance;
    }

    public List<?> findArticleByWeb() throws SQLException {
        return artSer.findArticleByWeb();
    }
}
