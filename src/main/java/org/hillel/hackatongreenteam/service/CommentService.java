package org.hillel.hackatongreenteam.service;

import org.hillel.hackatongreenteam.entity.Comment;

import java.util.List;

public interface CommentService {

    void create(Comment comment);

    Comment read(int id);

    List<Comment> readAll();

    Comment update(Comment article);

    void delete(int id);
}
