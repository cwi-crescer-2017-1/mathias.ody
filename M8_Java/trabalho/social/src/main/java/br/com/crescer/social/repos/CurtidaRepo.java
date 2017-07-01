package br.com.crescer.social.repos;

import br.com.crescer.social.entities.Curtida;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CurtidaRepo extends PagingAndSortingRepository<Curtida, Long> {
    
}
