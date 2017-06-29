/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.controllers;

import br.com.crescer.exercicio_aula7.entities.Locacao;
import br.com.crescer.exercicio_aula7.services.LocacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/locacao")
public class LocacaoRest {
    
    @Autowired
    LocacaoService locacaoService;

    @PostMapping()
    public String post(@PathVariable Locacao locacao) {
        locacaoService.post(locacao);
        return "Ok";
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        locacaoService.delete(id);
        return "Ok";
    }
    
    @GetMapping(value = "/{id}")
    public Locacao get(@PathVariable Long id) {
        return locacaoService.loadById(id);
    }
    
    @ResponseBody
    @GetMapping
    public List<Locacao> list() {
        return (List<Locacao>) locacaoService.findAll();
    }
}
