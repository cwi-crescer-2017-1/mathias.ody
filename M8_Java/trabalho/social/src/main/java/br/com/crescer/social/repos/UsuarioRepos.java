package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepos extends PagingAndSortingRepository<Usuario, Long> {
    public Usuario findOneByEmail(String email);
    public List<Usuario> findByNomeContainingIgnoreCase(String nomeUsuario);
}
