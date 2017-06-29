/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.services;

import br.com.crescer.exercicio_aula7.entities.Funcionario;
import br.com.crescer.exercicio_aula7.repos.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    public void post (Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    
    public void delete (Long id) {
        funcionarioRepository.delete(id);
    }
    
    public Funcionario loadById (Long id) {
        return funcionarioRepository.findOne(id);
    }
    
    public Iterable<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
}
