package it.uniroma3.siw.catering.repository.userdata;

import it.uniroma3.siw.catering.model.userdata.GoogleUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GoogleUserRepository extends CrudRepository<GoogleUser, Long> {
    public Optional<GoogleUser> findByEmail(String email);
}
