package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.enums.UserRole;
import com.revature.models.User;
import com.revature.services.IUserService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private IUserService us;
	
	@Autowired
	public CustomerController(IUserService us) {
		this.us = us;
	}
	
	@PostMapping("/login") // curly braces denote it as a path variable -> when can extract the data
	public ResponseEntity<User> logIn(@RequestBody User u){

		u.getUserRole();
		return new ResponseEntity<User>(us.login(u.getUsername(), u.getPassword()), HttpStatus.OK);

	}

}
