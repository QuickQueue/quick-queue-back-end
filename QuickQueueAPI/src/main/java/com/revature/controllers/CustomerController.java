package com.revature.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.services.ICartService;
import com.revature.services.IUserService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private IUserService us;
	private ICartService cartService;
	
	@Autowired
	public CustomerController(IUserService us, ICartService cartService) {
		this.us = us;
		this.cartService = cartService;
	}
	
	@PostMapping("/login") // curly braces denote it as a path variable -> when can extract the data
	public ResponseEntity<User> logIn(@RequestBody User u){
		return new ResponseEntity<User>(us.login(u.getUsername(), u.getPassword()), HttpStatus.OK);

	}
	
	@PostMapping("/addItem/{itemid}/{quantity}/{userid}")
	public ResponseEntity<Cart> addItem(@PathVariable int itemid, @PathVariable int quantity, @PathVariable int userid){
		//TODO check that user is logged in
		//get session
		
		return new ResponseEntity<Cart>(cartService.addItem(itemid, userid, quantity), HttpStatus.OK);

	}

}
