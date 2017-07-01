package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Post;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.crescer.social.services.PostService;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @PostMapping(value = "/post")
    public void adicionarPost(@RequestBody Post post, @AuthenticationPrincipal User user) {
        postService.save(post, user);
    }
}
