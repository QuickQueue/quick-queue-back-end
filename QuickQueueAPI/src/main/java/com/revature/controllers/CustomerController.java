package com.revature.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.exceptions.UnauthenticatedException;
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
	
	private static HttpSession getHttpSession(boolean makeNewSession) {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(makeNewSession);
	}
	
	@PostMapping("/login") // curly braces denote it as a path variable -> when can extract the data
	public ResponseEntity<User> logIn(@RequestBody User u){
		HttpSession sess = getHttpSession(true);
		u = us.login(u.getUsername(), u.getPassword());
		sess.setAttribute("user", u);
		return new ResponseEntity<User>((u), HttpStatus.OK);

	}
	
	@PostMapping("/addItem/{itemid}/{quantity}")
	public ResponseEntity<Cart> addItem(@PathVariable int itemid, @PathVariable int quantity){
		//TODO check that user is logged in
		HttpSession sess = getHttpSession(false);
		if(null == sess) {
			throw new UnauthenticatedException();
		}
		int userid = ((User) sess.getAttribute("user")).getUserId();
		return new ResponseEntity<Cart>(cartService.addItem(itemid, userid, quantity), HttpStatus.OK);

	}

}
