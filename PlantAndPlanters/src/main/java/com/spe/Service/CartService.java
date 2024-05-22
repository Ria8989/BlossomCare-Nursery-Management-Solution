package com.spe.Service;

import java.util.List;

import com.spe.Entity.Cart;
import com.spe.Entity.Planter;
import com.spe.Exception.CartException;
import com.spe.Exception.CustomerException;
import com.spe.Exception.PlanterException;

public interface CartService {

	public Cart addToCart( Integer CustomerId,Integer productId,Cart cart )
			throws CustomerException,CartException;
	
	public List<Planter> getAllItem ()throws CartException;
	
	public String deleteFromCart(Integer cartId,Integer planterId)
			throws PlanterException,CartException;
	
	public String emptyCart();
}
