package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Usuario;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import br.com.crescer.social.services.UsuarioService;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.security.core.Authentication;
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
    
    /*@GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }*/
    
    @GetMapping(value = "/usuarios")  
    public List<Usuario> listUsuarios() {
        return (List) usuarioService.findAll();
    }
    
    @GetMapping(value = "/usuario/buscar/{nome}")  
    public List<Usuario> findListUsuarios(@PathVariable String nome) {
        return usuarioService.findAll(nome);
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
    
    @PutMapping(value = "/usuario/editar")
    public void updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.update(usuario);
    }
    
    @GetMapping(value = "/usuario/amigos")
    public List<Usuario> getAmigosUsuario(@AuthenticationPrincipal User user) {
        return usuarioService.findByEmail(user.getUsername()).getAmigos();
    }
    
    @GetMapping("/usuarioLogado")
    public Map<String, Usuario> listarUsuarios(@AuthenticationPrincipal User user) {
        final Map<String, Usuario> hashMap = new HashMap<>();
        hashMap.put("dados", usuarioService.findByEmail(user.getUsername()));
        
        return hashMap;
    }
    
    @PostMapping(value = "/usuario/enviarSolicitacao/{id}")
    public void solicitar(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario logado = usuarioService.findByEmail(user.getUsername());
        Usuario solicitado = usuarioService.findById(id);
        
        usuarioService.enviarSolicitacao(logado, solicitado);
    }
    
    @PostMapping(value = "/usuario/aceitarSolicitacao/{id}")
    public void aceitarSolicitacao(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario logado = usuarioService.findByEmail(user.getUsername());
        Usuario aceito = usuarioService.findById(id);
        
        usuarioService.aceitarSolicitacao(logado, aceito);
    }
    
    @PostMapping(value = "/usuario/recusarSolicitacao/{id}")
    public void recusarSolicitacao(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario logado = usuarioService.findByEmail(user.getUsername());
        Usuario recusado = usuarioService.findById(id);
        
        usuarioService.recusarSolicitacao(logado, recusado);
    }
    
    @GetMapping(value = "/usuario/solicitacoes")
    public List<Usuario> getSolicitacoes(@AuthenticationPrincipal User user) {
        return usuarioService.findByEmail(user.getUsername()).getSolicitacoes();
    }
    
    @PostMapping(value = "/usuario/statusSolicitacao/{id}")
    public int statusSolicitacao(@PathVariable Long id,@AuthenticationPrincipal User user) {
        return usuarioService.statusSolicitacao(id);
    }
}
