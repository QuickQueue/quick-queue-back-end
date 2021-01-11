package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.mapping.Constraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.enums.CartStatus;
import com.revature.exceptions.CartNotFoundException;
import com.revature.models.Cart;
import com.revature.models.CartItem;
import com.revature.models.CartItemId;
import com.revature.models.Item;
import com.revature.repositories.ICartDao;
import com.revature.repositories.ICartItemDao;
import com.revature.repositories.IItemDao;
import com.revature.repositories.IUserDao;

@Service
public class CartServiceImpl implements ICartService {

	ICartDao cartDao;
//	IUserDao userDao;
	IItemDao itemDao;
	ICartItemDao cartItemDao;
	
	@Autowired
	public CartServiceImpl(ICartDao cartDao, IItemDao itemDao, ICartItemDao cartItemDao) {
		this.cartDao = cartDao;
		this.itemDao = itemDao;
		this.cartItemDao = cartItemDao;
	}
	
	@Override
	@Transactional
	public Cart addItem(int itemId, int userId, int quantity) {
		if(!itemDao.existsById(itemId)) {
			itemDao.save(new Item(itemId));
		}
		int cartId =0;
		try {
			cartId = cartDao.findActiveCart(userId).getCartId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CartItem ci = cartItemDao.getOne(new CartItemId(cartId, itemId));
		ci.setQuantity(ci.getQuantity() + quantity);
		cartItemDao.save(ci);
		return cartDao.getOne(cartId);
	}

	@Override
	@Transactional
	public Cart findActiveCart(int userId) {
		try {
			return cartDao.findActiveCart(userId);
		} catch (SQLException e) {
			throw new CartNotFoundException();
		}
	}

	@Override
	public List<Cart> findCartByStatus(int userId, CartStatus status) {
		try {
			return cartDao.findCartsByStatus(userId, status.toString());
		} catch (SQLException e) {
			throw new CartNotFoundException();
		}
	}

}
