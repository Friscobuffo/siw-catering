package it.uniroma3.siw.catering.repository.userdata;

import it.uniroma3.siw.catering.model.userdata.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}