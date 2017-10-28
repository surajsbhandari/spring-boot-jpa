package com.pinup.fas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pinup.fas.model.Person;
import com.pinup.fas.model.User;
import com.pinup.fas.service.DataService;

@RestController
public class DataController {

	@Autowired
	DataService dataService;

	@RequestMapping("/insertdummy")
	public String dummyMethodForInsert() {
		dataService.insertDummyData();
		return "Dummy data inserted in the DB";
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	public String saveUserData(@RequestBody Person person) {
		return dataService.saveUser(person);
	}
	
	@RequestMapping(value = "/save-user-test", method = RequestMethod.POST)
	public String saveUserDataTest(@RequestBody User user) {
		return dataService.saveUserTest(user);
	}

	@RequestMapping("/all-users")
	public List<Person> getAllUsersData() {
		return dataService.getAllUsers();
	}

	@RequestMapping("/all-users/{id}")
	public Person getPersonById(@PathVariable Long id) {
		return dataService.getPersonById(id);
	}

	@RequestMapping("/all-users-test/{id}")
	public User getUsersById(@PathVariable Long id) {
		return dataService.getUsersById(id);
	}

	@RequestMapping(value = "/remove-user/{id}", method = RequestMethod.DELETE)
	public String deleteUserData(@PathVariable Long id) {
		return dataService.deleteUser(id);
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.PUT)
	public String updateUserData(@RequestBody Person person) {
		return dataService.updateUser(person);
	}

	@Caching(evict = { @CacheEvict(value = "allUsers", allEntries = true),
			@CacheEvict(value = "userById", allEntries = true),
			@CacheEvict(value = "userByIdTest", allEntries = true) })
	@RequestMapping("/evict-cache")
	public void evictCache() {
		System.out.println("*** Cache Evicted ***");
	}
}
