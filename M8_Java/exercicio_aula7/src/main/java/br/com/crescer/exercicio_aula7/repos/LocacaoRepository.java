/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.repos;

import br.com.crescer.exercicio_aula7.entities.Locacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jomar
 */
public interface LocacaoRepository extends CrudRepository<Locacao, Long>{
    
}
