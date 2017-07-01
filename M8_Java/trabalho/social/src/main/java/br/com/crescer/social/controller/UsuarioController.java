package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Usuario;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import br.com.crescer.social.services.UsuarioService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
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
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    
    @DeleteMapping(value = "/usuario/{id}")
    public void removeUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
    }
    
    @PutMapping(value = "/usuario")
    public void updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.update(usuario);
    }
    
    @GetMapping(value = "/usuario/amigos")
    public List<Usuario> getAmigosUsuario(@AuthenticationPrincipal User user) {
        return usuarioService.findByEmail(user.getUsername()).getAmigos();
    }
}
