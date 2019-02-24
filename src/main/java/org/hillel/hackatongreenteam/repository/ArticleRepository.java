package org.hillel.hackatongreenteam.repository;

import org.hillel.hackatongreenteam.model.Article;
import org.hillel.hackatongreenteam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 23.02.2019.
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> getAllByCategory(Category category);
}
