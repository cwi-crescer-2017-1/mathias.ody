package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Post;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.crescer.social.services.PostService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public void postar(@RequestBody Post post, @AuthenticationPrincipal User user) {
        postService.postar(post);
    }
        
    @GetMapping(value = "posts")
    public List<Post> getlListPosts(@AuthenticationPrincipal User user, Pageable pageable) {
        return postService.getlListPosts(user, pageable);
    }
    
    @GetMapping(value = "posts/{id}")
    public List<Post> getPostsByUser(@PathVariable Long id) {
        return postService.getPostsByUserId(id);
    }
}
