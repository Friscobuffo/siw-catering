package it.uniroma3.siw.catering.repository.catering;

import it.uniroma3.siw.catering.model.catering.Chef;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChefRepository extends CrudRepository<Chef, Long> {

    Optional<Chef> findByNomeAndCognome(String nome, String cognome);
}
