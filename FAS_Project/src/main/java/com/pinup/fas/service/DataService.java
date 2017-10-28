package com.pinup.fas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pinup.fas.model.Person;
import com.pinup.fas.model.User;
import com.pinup.fas.repository.PersonRepository;
import com.pinup.fas.repository.UserRepository;

@Service
public class DataService {

	@Autowired
	Person person;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	UserRepository userRepository;
	
	public void insertDummyData() {
		person.setFirstName("Test");
		person.setLastName("User");
		person.setMobileNo("9876543210");
		personRepository.save(person);
		System.out.println("Person object saved");
	}

	public String saveUser(Person person) {
		personRepository.save(person);
		return "Record entered successfully";
	}
	
	public String saveUserTest(User user) {
		userRepository.save(user);
		return "Record entered successfully";
	}

	@Cacheable("allUsers")
	public List<Person> getAllUsers() {
		System.out.println("*** Inside getAllUsers() method ***");
		List<Person> personsList = new ArrayList<>();
		personsList = (List<Person>) personRepository.findAll();
		return personsList;
	}

	@Cacheable(value = "userById", key="#id")
	public Person getPersonById(Long id){
		System.out.println("Key from request :: " + id);
		return personRepository.findOne(id);
	}
	
	@Cacheable(value = "userByIdTest", key="#id")
	public User getUsersById(Long id){
		System.out.println("Key from request :: " + id);
		return userRepository.findOne(id);
	}
	
	public String deleteUser(Long id) {
		personRepository.delete(id);
		return "Record deleted successfully";
	}

	public String updateUser(Person person) {
		personRepository.save(person);
		return "Record Updated successfully";
	}

}
