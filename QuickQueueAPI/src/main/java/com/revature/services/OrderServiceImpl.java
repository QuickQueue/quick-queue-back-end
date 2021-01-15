package com.revature.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.enums.OrderStatus;
import com.revature.exceptions.OrderNotFoundException;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.repositories.IOrderDao;

@Service
public class OrderServiceImpl implements IOrderService{
	
	IOrderDao orderDao;
	
	@Autowired
	public OrderServiceImpl(IOrderDao orderDao) {
		
		this.orderDao = orderDao;
		
	}

	@Override
	@Transactional
	public Order addOrder(Order o) {
		
		return orderDao.save(o);
		
	}

	@Override
	public List<Order> findOrderByStatus(User orderCustomer, OrderStatus status) {		
		
		return orderDao.findOrderByStatus(orderCustomer.getUserId(), status.toString());
	
	}

	@Override
	public Order updateOrderStatus(Order o) {
		
		return orderDao.save(o);
		
	}

}
