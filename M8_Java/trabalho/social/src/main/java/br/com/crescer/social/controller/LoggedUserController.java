package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Usuario;
import br.com.crescer.social.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */
@RestController
@RequestMapping(LoggedUserController.PATH)
public class LoggedUserController {
    
    @Autowired
    UsuarioService usuarioService;

    public static final String PATH = "/logged-user";

    @GetMapping
    public Usuario getUserDetails(Authentication authentication) {
        return usuarioService.getLogado();
    }
}
