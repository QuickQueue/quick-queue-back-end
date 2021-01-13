package com.revature.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.revature.enums.OrderStatus;
import com.revature.models.Order;
import com.revature.models.User;

public interface IOrderService {

	Order addOrder(Order o);
	
	//Shopper Login -> retrive list order ^ -> which order to move to pending(if shopping), closed if delivered
	Order changeOrderStatus(int orderId, User shoppderId,  OrderStatus status);
	
//	thought pattern for how to add order services?
//  mine: what user will do on front end
//  shopper will 'accept an order'
//	customer will 'get order history' from a drop down selecting by order status(i.e. past orders, pending orders etc.)
//  Are the variables in addOrder correct? i.e. are those the params were are sending, also userId is orderId?
	
	// Order findActiveOrder(User orderCustomer);
	
	// Customer login -> 'order history' -> drop downmenu (pending, active, complete) -> display
	List<Order> findByStatus(User orderCustomer, OrderStatus status);
	
}
