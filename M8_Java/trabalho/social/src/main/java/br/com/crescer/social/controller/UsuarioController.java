/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Usuario;
import br.com.crescer.social.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mathias.ody
 */
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;   
    
    @GetMapping(value = "/usuario")
    public List<Usuario> listUsuarios() {
        return (List) usuarioService.findAll();
    }
    
    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
    
    @PostMapping(value = "/usuario")
    public void addUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastrar(usuario);
    }
    
    @DeleteMapping(value = "/usuario/{id}")
    public void removeCliente(@PathVariable Long id) {
        usuarioService.delete(id);
    }
    
    @PutMapping(value = "/usuario")
    public void updateCliente(@RequestBody Usuario usuario) {
        usuarioService.update(usuario);
    }
}
