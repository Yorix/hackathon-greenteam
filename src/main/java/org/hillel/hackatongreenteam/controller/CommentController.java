package org.hillel.hackatongreenteam.controller;

import org.hillel.hackatongreenteam.model.Comment;
import org.hillel.hackatongreenteam.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {


    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("{id}")
    public RestResponse read(@PathVariable("id") int id) {
        RestResponse response = new RestResponse();
        Comment comment = commentService.read(id);
        if (comment == null) {
            response.setStatus(404);
            response.setMessage(String.format("Comment %d not found", id));
        } else {
            response.setStatus(200);
            response.setData(response);
        }
        return response;
    }

    @GetMapping
    public RestResponse readAll(@RequestBody int articleId) {
        RestResponse response = new RestResponse();
        response.setStatus(200);
        response.setData(commentService.readAll(articleId));
        return response;
    }

    @PostMapping
    public RestResponse create(@RequestBody Comment comment) {
        RestResponse response = new RestResponse();
        response.setStatus(201);
        response.setMessage("Comment has created");
        response.setData(commentService.save(comment));
        return response;
    }

    @PutMapping("{id}")
    public RestResponse update(@PathVariable("id") Comment commentFromDB,
                               @RequestBody Comment comment) {
        BeanUtils.copyProperties(comment, commentFromDB, "id");

        RestResponse response = new RestResponse();
        response.setStatus(200);
        response.setMessage("The comment has updated");
        response.setData(commentService.save(commentFromDB));
        return response;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        commentService.delete(id);
    }

}
