package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void create(Article article) {
        articleDao.create(article);
    }

    @Override
    public Article read(int id) {
        return articleDao.read(id);
    }

    @Override
    public List<Article> readAll() {
        return articleDao.readAll();
    }

    @Override
    public Article update(Article article) {
        return articleDao.update(article);
    }

    @Override
    public void delete(int id) {
        articleDao.delete(id);
    }
}
