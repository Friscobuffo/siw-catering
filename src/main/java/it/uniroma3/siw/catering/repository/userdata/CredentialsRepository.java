package it.uniroma3.siw.catering.repository.userdata;

import it.uniroma3.siw.catering.model.userdata.Credentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
	public Optional<Credentials> findByUsername(String username);
}