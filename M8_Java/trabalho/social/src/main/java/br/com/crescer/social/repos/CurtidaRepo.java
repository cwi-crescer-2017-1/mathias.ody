/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Curtida;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author mathias.ody
 */
public interface CurtidaRepo extends PagingAndSortingRepository<Curtida, Long> {
    
}
