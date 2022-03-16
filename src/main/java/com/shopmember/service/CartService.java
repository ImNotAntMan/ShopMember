package com.shopmember.service;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;

public interface CartService { 
	
	public void cartinsert(CartmainVO cartmain, CartsubVO cartsub);
	
}
