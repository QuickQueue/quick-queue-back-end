package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.exceptions.UnauthenticatedException;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.services.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private IOrderService os;
	
	@Autowired
	public OrderController(IOrderService os) {
			
		this.os = os;
		
	}
	
	private static HttpSession getHttpSession(boolean makeNewSession) {
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(makeNewSession);
		
	}
	
	@PostMapping("/submit")
	public ResponseEntity<Order> submitNewOrder(@RequestBody Order o) {
		
		HttpSession sess = getHttpSession(false);
		User u = (User) sess.getAttribute("user");
		if (!o.getOrderCustomer().equals(u)) {
				
			throw new UnauthenticatedException();
			
		}
		return new ResponseEntity<Order>(os.addOrder(o), HttpStatus.OK);
		
	}
	
}
