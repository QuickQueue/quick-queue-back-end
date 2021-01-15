package com.revature.services;

import java.util.List;

import com.revature.enums.OrderStatus;
import com.revature.models.Order;
import com.revature.models.User;

public interface IOrderService {

	Order addOrder(Order o);
	
	Order updateOrderStatus(Order o);

	List<Order> findOrderByStatus(User orderCustomer, OrderStatus status);

}
