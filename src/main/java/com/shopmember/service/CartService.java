package com.shopmember.service;

import com.it.domain.CartmainVO;
import com.it.domain.CartsubVO;

public interface CartService {
	
	public void cartinsert(CartmainVO cartmain, CartsubVO cartsub);
	
}
