package org.hillel.hackatongreenteam.repository;

import org.hillel.hackatongreenteam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 23.02.2019.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
