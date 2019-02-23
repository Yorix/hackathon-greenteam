package org.hillel.hackatongreenteam.service;

import org.hillel.hackatongreenteam.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment create(Comment comment);

    Comment read(int id);

    List<Comment> readAll();

    Comment update(Comment comment);

    void delete(int id);
}
