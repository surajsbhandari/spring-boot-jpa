package com.pinup.fas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pinup.fas.model.Person;
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
		System.out.println("Input from request: " + person.toString());
		String result = dataService.saveUser(person);
		return result;
	}
	
	@RequestMapping("/all-users")
	public List<Person> getAllUsersData(){
		return dataService.getAllUsers();
	}
	
}
