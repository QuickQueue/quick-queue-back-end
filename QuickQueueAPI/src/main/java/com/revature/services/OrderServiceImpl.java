package com.revature.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.revature.enums.OrderStatus;
import com.revature.models.Order;
import com.revature.models.User;

public class OrderServiceImpl implements IOrderService{

	@Override
	public Order addOrder(int orderId, BigDecimal orderNetAmount, BigDecimal order_gross_amount,
			BigDecimal order_tax_amount, Timestamp orderSubmitted, String orderAdditionalInstructions,
			User orderCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order changeOrderStatus(int orderId, User shoppderId, OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByStatus(User orderCustomer, OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

}
