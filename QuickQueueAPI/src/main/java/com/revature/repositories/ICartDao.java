package com.revature.repositories;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Cart;
import com.revature.models.User;

public interface ICartDao extends JpaRepository<Cart, Integer> {

	 @Query("select c FROM Cart c where (c.cartId = ?1 and c.cartStatus = 'ACTIVE')")	
	 public Cart findActiveCart(int userId) throws SQLException;
}
