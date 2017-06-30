/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author mathias.ody
 */
public interface UsuarioRepo extends PagingAndSortingRepository<Usuario, Long> {
    
    public Usuario findByEmail(String email);   
}
