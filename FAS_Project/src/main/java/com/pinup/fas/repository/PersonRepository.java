package com.pinup.fas.repository;

import org.springframework.data.repository.CrudRepository;

import com.pinup.fas.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
