package br.com.crescer.social.services;

import br.com.crescer.social.entities.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repos.UsuarioRepos;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepos repo;

    public Iterable<Usuario> findAll() {
        return repo.findAll();
    }
    
    public Usuario findById(Long id) {
        return repo.findOne(id);
    }

    public Usuario findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public void delete(Long id) {
        repo.delete(id);
    }

    public Usuario save(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return repo.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return repo.save(usuario);
    }
}
