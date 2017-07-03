package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Post;
import br.com.crescer.social.entities.Usuario;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepos extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUsuarioInOrderByIdDesc(List<Usuario> usuarios, Pageable pageable);
    Post findById(Long id);
}
