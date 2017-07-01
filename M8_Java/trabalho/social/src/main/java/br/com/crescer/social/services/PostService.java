package br.com.crescer.social.services;

import br.com.crescer.social.entities.Post;
import br.com.crescer.social.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repos.PostRepos;

@Service
public class PostService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostRepos repo;

    public Iterable<Post> findAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.delete(id);
    }

    public Post findById(Long id) {
        return repo.findOne(id);
    }

    public Post save(Post post, User user) {
        Usuario usuarioLogado = usuarioService.findByEmail(user.getUsername());
        post.setUsuario(usuarioLogado);
        return repo.save(post);
    }

    public Post update(Post post) {
        return repo.save(post);
    }
}
