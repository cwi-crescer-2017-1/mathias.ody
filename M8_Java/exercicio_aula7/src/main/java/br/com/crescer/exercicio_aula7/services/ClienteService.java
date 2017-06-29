/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.services;

import br.com.crescer.exercicio_aula7.entities.Cliente;
import br.com.crescer.exercicio_aula7.entities.Genero;
import br.com.crescer.exercicio_aula7.repos.ClienteRepository;
import br.com.crescer.exercicio_aula7.repos.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public void post (Cliente cliente) {
        clienteRepository.save(cliente);
    }
    
    public void delete (Long id) {
        clienteRepository.delete(id);
    }
    
    public Cliente loadById (Long id) {
        return clienteRepository.findOne(id);
    }
    
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
