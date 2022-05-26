package com.servizio_catering.repository;

import com.servizio_catering.model.userdata.Credentials;
import com.servizio_catering.model.userdata.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}