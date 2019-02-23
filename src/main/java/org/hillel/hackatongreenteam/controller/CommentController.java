package org.hillel.hackatongreenteam.controller;

import org.hillel.hackatongreenteam.model.Comment;
import org.hillel.hackatongreenteam.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CommentController {

    @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("{id}")
    public Comment getOne(@PathVariable("id") int id) {
        return commentService.read(id);
    }

    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("{id}")
    public Comment update(@PathVariable("id") Comment commentFromDB,
                          @RequestBody Comment comment) {
        BeanUtils.copyProperties(comment, commentFromDB, "id");
        return commentService.update(commentFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        commentService.delete(id);
    }

}
