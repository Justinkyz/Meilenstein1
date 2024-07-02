package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://blackjack-tent.onrender.com"})
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}
