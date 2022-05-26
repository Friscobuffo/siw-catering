package com.servizio_catering.repository;

import com.servizio_catering.model.userdata.GoogleUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GoogleUserRepository extends CrudRepository<GoogleUser, Long> {
    public Optional<GoogleUser> findByEmail(String email);
}
