/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.controllers;

import br.com.crescer.exercicio_aula7.entities.Cliente;
import br.com.crescer.exercicio_aula7.services.ClienteService;
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
@RequestMapping(value = "/Cliente")
public class ClienteRest {
    @Autowired
    ClienteService ClienteService;

    @PostMapping()
    public String post(@PathVariable Cliente cliente) {
        ClienteService.post(cliente);
        return "Ok";
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        ClienteService.delete(id);
        return "Ok";
    }
    
    @GetMapping(value = "/{id}")
    public Cliente get(@PathVariable Long id) {
        return ClienteService.loadById(id);
    }
    
    @ResponseBody
    @GetMapping
    public List<Cliente> list() {
        return (List<Cliente>) ClienteService.findAll();
    }
}
