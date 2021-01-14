package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.enums.OrderStatus;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UrlMismatchException;
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
	
	@GetMapping("/history/pending")
	public ResponseEntity<List<Order>> getPendingOrders() {
		
		HttpSession sess = getHttpSession(false);
		User u = (User) sess.getAttribute("user");
		return new ResponseEntity<List<Order>>(os.findOrderByStatus(u, OrderStatus.PENDING), HttpStatus.OK);
		
	}
	
	@GetMapping("/history/active")
	public ResponseEntity<List<Order>> getActiveOrders() {
		
		HttpSession sess = getHttpSession(false);
		User u = (User) sess.getAttribute("user");
		return new ResponseEntity<List<Order>>(os.findOrderByStatus(u, OrderStatus.ACTIVE), HttpStatus.OK);
		
	}
	
	@GetMapping("/history/closed")
	public ResponseEntity<List<Order>> getClosedOrders() {
		
		HttpSession sess = getHttpSession(false);
		User u = (User) sess.getAttribute("user");
		return new ResponseEntity<List<Order>>(os.findOrderByStatus(u, OrderStatus.CLOSED), HttpStatus.OK);
		
	}
	
	@PostMapping("/{orderId}")
	public ResponseEntity<Order> updateOrderStatus(@RequestBody Order o, @PathVariable int orderId) {
		
		HttpSession sess = getHttpSession(false);
		if(null == sess) {
			throw new UnauthenticatedException();
		} else if (o.getOrderId() == orderId) {
			throw new UrlMismatchException();
		} 
		
		return new ResponseEntity<Order>(os.updateOrderStatus(o), HttpStatus.OK);
		
	}
	
}
