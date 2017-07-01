package br.com.crescer.social.services;

import br.com.crescer.social.entities.Curtida;
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
    
    public Curtida save(Curtida like, User user, Long idPost) {
        like.setPost(postService.findById(idPost));
        like.setUsuarioCurtida(usuarioService.findByEmail(user.getUsername()));
        return repo.save(like);
    }
    
    public void delete(Long id) {
        repo.delete(id);
    }
}
