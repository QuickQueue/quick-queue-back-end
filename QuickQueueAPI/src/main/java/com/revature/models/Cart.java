package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.enums.CartStatus;

@Entity
@Table(name = "carts")
public class Cart {
	
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

//	@Column(name = "cart_customer_id")
//	int cartCustomerId;

//	@Column(name = "cart_shopper_id")
//	int cartShopperId;

    @Enumerated(EnumType.STRING)
	@Column(name = "cart_status")
//	@Type(type = "org.thoughts.on.java.model.EnumTypePostgreSql")
    private CartStatus cartStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_customer_id")
	@JsonBackReference
	private User cartOwner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_shopper_id")
	private User cartShopper;

	public Cart() {
		super();
		
	}

	public Cart(int cartId, CartStatus cartStatus, User cartOwner, User cartShopper) {
		super();
		this.cartId = cartId;
		this.cartStatus = cartStatus;
		this.cartOwner = cartOwner;
		this.cartShopper = cartShopper;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public CartStatus getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(CartStatus cartStatus) {
		this.cartStatus = cartStatus;
	}

	public User getCartOwner() {
		return cartOwner;
	}

	public void setCartOwner(User cartOwner) {
		this.cartOwner = cartOwner;
	}

	public User getCartShopper() {
		return cartShopper;
	}

	public void setCartShopper(User cartShopper) {
		this.cartShopper = cartShopper;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		result = prime * result + ((cartOwner == null) ? 0 : cartOwner.hashCode());
		result = prime * result + ((cartShopper == null) ? 0 : cartShopper.hashCode());
		result = prime * result + ((cartStatus == null) ? 0 : cartStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		if (cartOwner == null) {
			if (other.cartOwner != null)
				return false;
		} else if (!cartOwner.equals(other.cartOwner))
			return false;
		if (cartShopper == null) {
			if (other.cartShopper != null)
				return false;
		} else if (!cartShopper.equals(other.cartShopper))
			return false;
		if (cartStatus != other.cartStatus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartStatus=" + cartStatus + ", cartOwner=" + cartOwner + ", cartShopper="
				+ cartShopper + "]";
	}

}
