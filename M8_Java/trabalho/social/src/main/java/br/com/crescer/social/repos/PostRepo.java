/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Post;
import br.com.crescer.social.entities.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author mathias.ody
 */
public interface PostRepo extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUsuarioInOrderByIdDesc(List<Usuario> usuarios, Pageable pageable);
}
