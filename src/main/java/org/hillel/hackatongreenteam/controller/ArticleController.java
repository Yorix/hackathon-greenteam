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

    @GetMapping("{id}")
    public RestResponse getOne(@PathVariable("id") int id) {
        RestResponse response = new RestResponse();

        Article article = articleService.read(id);
        if (article == null){
            response.setStatus(404);
            response.setMessage(String.format("Category %d not found", id));
        } else {
            response.setStatus(200);
            response.setData(article);
        }

        return response;
    }


    @PostMapping
    public RestResponse create(@RequestBody Article article) {
        RestResponse response = new RestResponse();
        response.setStatus(201);
        response.setMessage("A new article has created");
        response.setData(articleService.save(article));

        return response;
    }

    @PutMapping("{id}")
    public RestResponse update(@PathVariable("id") Article articleFromDB,
                          @RequestBody Article article) {
        BeanUtils.copyProperties(article, articleFromDB, "id");

        RestResponse response = new RestResponse();
        response.setStatus(200);
        response.setMessage("The article has updated");
        response.setData(articleService.save(articleFromDB));

        return response;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        articleService.delete(id);
    }
}
