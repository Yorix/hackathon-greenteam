package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.Article;
import org.hillel.hackatongreenteam.repository.ArticleRepository;
import org.hillel.hackatongreenteam.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
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
    public List<Article> readAll(int categoryId) {
        return articleRepository.getAllByCategory(categoryRepository.getOne(categoryId));
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(int id) {
//        articleRepository.delete(id);
    }
}
