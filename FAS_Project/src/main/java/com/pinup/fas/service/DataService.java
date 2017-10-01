package com.pinup.fas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinup.fas.model.Person;
import com.pinup.fas.repository.PersonRepository;

@Service
public class DataService {

	@Autowired
	Person person;

	@Autowired
	PersonRepository personRepository;

	public void insertDummyData() {
		person.setFirstName("Test");
		person.setLastName("User");
		person.setMobileNo("9876543210");
		personRepository.save(person);
		System.out.println("Person object saved");
	}
	
	public String saveUser(Person person){
		personRepository.save(person);		
		return "success";
	}

	public List<Person> getAllUsers(){
		List<Person> personsList = new ArrayList<>();
		personsList = (List<Person>) personRepository.findAll();		
		return personsList;
	}
	
}
