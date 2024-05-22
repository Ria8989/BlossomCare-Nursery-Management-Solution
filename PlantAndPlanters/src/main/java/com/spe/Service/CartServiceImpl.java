package com.spe.Service;

import java.util.List;

import com.spe.Entity.Cart;
import com.spe.Entity.Planter;
import com.spe.Exception.CartException;
import com.spe.Exception.CustomerException;
import com.spe.Exception.PlanterException;

public class CartServiceImpl implements CartService {

	@Override
	public Cart addToCart(Integer CustomerId, Integer productId, Cart cart) throws CustomerException, CartException {

		return null;
	}

	@Override
	public List<Planter> getAllItem() throws CartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFromCart(Integer cartId, Integer planterId) throws PlanterException, CartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emptyCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
