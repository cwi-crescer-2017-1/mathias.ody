package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepos extends PagingAndSortingRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}
