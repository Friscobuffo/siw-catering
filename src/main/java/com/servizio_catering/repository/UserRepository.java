package com.servizio_catering.repository;

import com.servizio_catering.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}