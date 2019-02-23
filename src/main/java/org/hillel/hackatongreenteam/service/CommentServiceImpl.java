package org.hillel.hackatongreenteam.service;

import org.hillel.hackatongreenteam.model.Comment;
import org.hillel.hackatongreenteam.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment read(int id) {
        return commentRepository.getOne(id);
    }

    @Override
    public List<Comment> readAll(int articleId) {
        return commentRepository
                .findAll(Sort.by("dateCreated").descending())
                .stream()
                .filter(comment -> comment.getArticle().getId() == articleId)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        Comment comment = commentRepository.getOne(id);
        commentRepository.delete(comment);
    }
}
