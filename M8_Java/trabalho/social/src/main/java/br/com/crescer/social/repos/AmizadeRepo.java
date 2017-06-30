/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Amizade;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author mathias.ody
 */
public interface AmizadeRepo extends PagingAndSortingRepository<Amizade, Long> {
    
}
