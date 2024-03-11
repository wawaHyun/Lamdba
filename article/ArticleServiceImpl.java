
package com.turing.api.article;

import common.AbstractService;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService{

    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    ArticleRepository res;

    private ArticleServiceImpl() {
        this.res = ArticleRepository.getInstance();
    }

    public static ArticleServiceImpl getInstance() {
        return instance;
    }


    @Override
    public Messenger save(Article article) {
        return null;
    }

    @Override
    public Messenger save2(Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Article> getOne(String memberid) {
        return Optional.empty();
    }

    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

    @Override
    public List<?> findArticleByWeb() throws SQLException {
        return res.findArticleByWeb();
    }


}