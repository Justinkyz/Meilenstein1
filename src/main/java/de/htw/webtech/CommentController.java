package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = {"https://blackjack-tent.onrender.com"})
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}
