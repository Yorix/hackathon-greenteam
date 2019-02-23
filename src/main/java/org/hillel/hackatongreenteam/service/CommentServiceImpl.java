package org.hillel.hackatongreenteam.service;

import org.hillel.hackatongreenteam.model.Comment;
import org.hillel.hackatongreenteam.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return null;
    }

    @Override
    public Comment read(int id) {
        return null;
    }

    @Override
    public List<Comment> readAll() {
        return null;
    }

    @Override
    public Comment update(Comment article) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
