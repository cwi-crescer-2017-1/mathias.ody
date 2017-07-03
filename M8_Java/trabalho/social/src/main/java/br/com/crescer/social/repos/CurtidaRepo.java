package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Curtida;
import br.com.crescer.social.entities.Post;
import br.com.crescer.social.entities.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CurtidaRepo extends PagingAndSortingRepository<Curtida, Long> {
    Curtida findByPostAndUsuario(Post post, Usuario usuario);
}
