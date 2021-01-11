package com.revature.services;

import com.revature.models.Cart;
import com.revature.models.CartItem;
import com.revature.models.CartItemId;

public interface ICartService {

	Cart addItem(int itemId, int userId, int quantity);
	
}
