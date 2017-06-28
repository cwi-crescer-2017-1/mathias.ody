/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.repos;

import br.com.crescer.aula7.entities.Ator;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mathias.ody
 */
public interface AtorRepo extends CrudRepository<Ator,Long> {
    
}
