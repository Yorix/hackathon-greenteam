package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.Article;
import org.hillel.hackatongreenteam.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article read(int id) {
        return articleRepository.getOne(id);
    }

    @Override
    public List<Article> readAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article update(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(int id) {
//        articleRepository.delete(id);
    }
}
