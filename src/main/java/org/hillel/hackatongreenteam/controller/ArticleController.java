package org.hillel.hackatongreenteam.controller;

import org.hillel.hackatongreenteam.model.Article;
import org.hillel.hackatongreenteam.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //@GetMapping
    /*@JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepository.findAll();
    }*/

    @GetMapping("{id}")
    public Article getOne(@PathVariable("id") int id) {
        return articleService.read(id);
    }


    @PostMapping
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("{id}")
    public Article update(@PathVariable("id") Article articleFromDB,
                          @RequestBody Article article) {
        BeanUtils.copyProperties(article, articleFromDB, "id");
        return articleService.update(articleFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        articleService.delete(id);
    }
}
