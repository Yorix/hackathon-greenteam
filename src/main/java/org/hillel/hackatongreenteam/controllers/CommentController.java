package garbage.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class CommentController {

    @Autowired
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    @GetMapping("{id}")
    public Comment getOne(@PathVariable("id") Comment comment) {
        return comment;
    }


    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        comment.setCreationDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @PutMapping("{id}")
    public Comment update(@PathVariable ("id") Comment commentFromDB,
                          @RequestBody Article comment) {
        BeanUtils.copyProperties(comment, commentFromDB, "id");
        return commentRepository.save(commentFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") Comment comment) {
        commentRepository.delete(comment);
    }
}
