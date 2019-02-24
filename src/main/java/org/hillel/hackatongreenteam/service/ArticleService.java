package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.Article;

import java.util.List;

public interface ArticleService {

    Article read(int id);

    List<Article> readAll();

    List<Article> readAll(int categoryId);

    Article save(Article article);

    void delete(int id);
}
