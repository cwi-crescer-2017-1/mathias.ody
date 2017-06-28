/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entities.Ator;
import br.com.crescer.aula7.services.AtorService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mathias.ody
 */
@RestController
public class AtorController {

    @Autowired
    AtorService atorService;
    
    @GetMapping("/atores")
    public List<Ator> list() {
        return atorService.list();
    }
    
    @PostMapping("/atores")
    public void add(@RequestBody Ator ator) {
        atorService.addAtor(ator);
    }
}
