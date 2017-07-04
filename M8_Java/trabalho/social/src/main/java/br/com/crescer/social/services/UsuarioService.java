package br.com.crescer.social.services;

import br.com.crescer.social.entities.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.social.repos.UsuarioRepos;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepos repo;

    public Iterable<Usuario> findAll() {
        return repo.findAll();
    }
    
    public List<Usuario> findAll(String nome) {
        List<Usuario> usuarios = repo.findByNomeContainingIgnoreCase(nome);
        usuarios.remove(getLogado());
        return usuarios;
    }
    
    public Usuario findById(Long id) {
        return repo.findOne(id);
    }

    public Usuario findByEmail(String email) {
        return repo.findOneByEmail(email);
    }

    public void delete(Long id) {
        repo.delete(id);
    }

    public Usuario save(Usuario usuario) {
        String str = usuario.getFotoPerfil();
        if(str == null || str.isEmpty()) {
            usuario.setFotoPerfil("http://mthumbs.buscape.com.br/churrasqueira/mor-araguaia-carvao_300x300-PU48449_1.jpg");
        }
        
        if (findByEmail(usuario.getEmail()) != null){
            return null;
        }
        
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return repo.save(usuario);
    }

    public Usuario updateEditar(Usuario usuario) {
        Usuario antigo = repo.findOneById(usuario.getId());
        usuario.setAmigos(antigo.getAmigos());
        usuario.setSolicitacoes(antigo.getSolicitacoes());
        
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()){
            usuario.setSenha(antigo.getSenha());
        }
        else {
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        }

        return repo.save(usuario);
    }
    
    public Usuario update(Usuario usuario) {
        return repo.save(usuario);
    }
    
    //0 - não enviada, 1 - enviada por mim (logado), 2 - enviada pelo outro, 3 - aceita
    public int statusSolicitacao(Long id) {
        //return repo.save(usuario);
        Usuario logado = getLogado();
        if (jaEnviouSolicitacao(logado, id)){
            return 1;
        }
        
        if (jaRecebeuSolicitacao(logado, id)){
            return 2;
        }
        
        if (jaEAmigo(logado,id)){
            return 3;
        }
        return 0;
    }
    
    public boolean jaEnviouSolicitacao(Usuario logado, Long id) {
        return findById(id).getSolicitacoes().contains(logado);
    }
    
    public boolean jaRecebeuSolicitacao(Usuario logado, Long id) {
        return logado.getSolicitacoes().contains(findById(id));
    }
    
    public boolean jaEAmigo(Usuario logado, Long id) {
        return logado.getAmigos().contains(findById(id));
    }
    
    public Usuario getLogado() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(this::findByEmail)
                .orElse(null);
    }

    public void aceitarSolicitacao(Usuario logado, Usuario aceito) {
        logado.getSolicitacoes().remove(aceito); //remover das solicitacoes
        //adicionar relacao de amizade
        logado.getAmigos().add(aceito);
        aceito.getAmigos().add(logado);
        //profit!
        update(logado);
        update(aceito);
    }
    
    public void recusarSolicitacao(Usuario logado, Usuario recusado) {
        logado.getSolicitacoes().remove(recusado); //remover das solicitacoes
        update(logado);
    }

    public void enviarSolicitacao(Usuario logado, Usuario solicitado) {
        solicitado.getSolicitacoes().add(logado);
        update(solicitado); //igual ao save, mas não cria novo
    }
}
