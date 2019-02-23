package garbage.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {

        this.articleRepository = articleRepository;
    }

    //@GetMapping
    /*@JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepository.findAll();
    }*/

    @GetMapping("{id}")
    public Article getOne(@PathVariable("id") Article article) {
        return article;
    }


    @PostMapping
    public Article create(@RequestBody Article article) {
        article.setCreationDate(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @PutMapping("{id}")
    public Article update(@PathVariable ("id") Article articleFromDB,
                          @RequestBody Article article) {
        BeanUtils.copyProperties(article, articleFromDB, "id");
        return articleRepository.save(articleFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") Article article) {
        articleRepository.delete(article);
    }
}
