/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.services;

import br.com.crescer.social.entities.Usuario;
import br.com.crescer.social.repos.UsuarioRepo;
import java.awt.print.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathias.ody
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepositorio;
    
    public Iterable<Usuario> findAll() {
       return usuarioRepositorio.findAll();
    }

    public void delete(Long id) {
        usuarioRepositorio.delete(id);
    }

    public Usuario findById(Long id) {
        return usuarioRepositorio.findOne(id);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepositorio.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
