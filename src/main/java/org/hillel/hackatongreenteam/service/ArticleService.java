package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.Article;

import java.util.List;

public interface ArticleService {
    Article create(Article article);

    Article read(int id);

    List<Article> readAll();

    Article update(Article article);

    void delete(int id);
}
