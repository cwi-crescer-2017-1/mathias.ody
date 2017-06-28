/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.entities.Ator;
import br.com.crescer.aula7.repos.AtorRepo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathias.ody
 */
@Service
public class AtorService {

    @Autowired
    AtorRepo atorRepo; 
    
    public List<Ator> list() {
        return (List)atorRepo.findAll();
    }

    public void addAtor(Ator ator) {
        atorRepo.save(ator);
    }
}
