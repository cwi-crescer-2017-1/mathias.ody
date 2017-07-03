package br.com.crescer.social.controller;

import br.com.crescer.social.entities.Curtida;
import br.com.crescer.social.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurtidaController {
    
    @Autowired
    private CurtidaService curtidaService;
    
    @PostMapping(value = "/curtir/{id}")
    public void curtir(@RequestBody Curtida curtida, @AuthenticationPrincipal User user, @PathVariable Long id) {
        curtidaService.save(curtida, user, id);
    }
    
    /*@PostMapping(value = "/descurtir/{id}")
    public void descurtir(@PathVariable Long id) {
        curtidaService.delete(id);
    }*/
}
