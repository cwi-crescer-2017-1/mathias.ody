package br.com.crescer.social.services;

import br.com.crescer.social.entities.Curtida;
import br.com.crescer.social.entities.Post;
import br.com.crescer.social.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repos.CurtidaRepo;

@Service
public class CurtidaService {
    
    @Autowired
    private CurtidaRepo repo;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Curtida save(Curtida curtida, User user, Long idPost) {  
        Usuario curtidor = usuarioService.findByEmail(user.getUsername());
        Post post = postService.findById(idPost);
        
        if (post.getCurtidas().stream().map (x -> x.getUsuarioCurtida()).equals(curtidor)){
            delete(idPost);
            return null;
        }
        else {
            curtida.setPost(post);
            curtida.setUsuarioCurtida(curtidor);
            return repo.save(curtida);
        }
    }
    
    public void delete(Long id) {
        repo.delete(id);
    }
}
