/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.services;

import br.com.crescer.exercicio_aula7.entities.Genero;
import br.com.crescer.exercicio_aula7.entities.Locacao;
import br.com.crescer.exercicio_aula7.repos.GeneroRepository;
import br.com.crescer.exercicio_aula7.repos.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    
    @Autowired
    LocacaoRepository locacaoRepository;
    
    public void post (Locacao locacao) {
        locacaoRepository.save(locacao);
    }
    
    public void delete (Long id) {
        locacaoRepository.delete(id);
    }
    
    public Locacao loadById (Long id) {
        return locacaoRepository.findOne(id);
    }
    
    public Iterable<Locacao> findAll() {
        return locacaoRepository.findAll();
    }
}
