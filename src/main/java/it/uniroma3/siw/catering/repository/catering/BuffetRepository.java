package it.uniroma3.siw.catering.repository.catering;

import it.uniroma3.siw.catering.model.catering.Buffet;
import org.springframework.data.repository.CrudRepository;

public interface BuffetRepository extends CrudRepository<Buffet, Long> {
    void deleteById(Long id);
}
