package br.com.crescer.social.services;

import br.com.crescer.social.entities.Post;
import br.com.crescer.social.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repos.PostRepos;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;

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

    public Post postar(Post post) {
        Usuario usuarioLogado = usuarioService.getLogado();
        post.setUsuario(usuarioLogado);
        post.setDataPostagem(new Date());
        return repo.save(post);
    }
    
    public List<Post> getlListPosts(User user, Pageable pageable) {
        List<Usuario> amigosUsuario = usuarioService.findByEmail(user.getUsername()).getAmigos();
        return repo.findByUsuarioInOrderByIdDesc(amigosUsuario, pageable);
    }

    public List<Post> getPostsByUserId(Long id) {
        return usuarioService.findById(id).getPosts();
    }
    
    public Post update(Post post) {
        return repo.save(post);
    }
}
