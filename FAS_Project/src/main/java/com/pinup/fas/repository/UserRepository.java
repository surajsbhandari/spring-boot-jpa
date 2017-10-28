package com.pinup.fas.repository;

import org.springframework.data.repository.CrudRepository;

import com.pinup.fas.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
