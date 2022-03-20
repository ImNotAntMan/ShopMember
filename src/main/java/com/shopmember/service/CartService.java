package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.CartdetailDTO;
import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;

public interface CartService { 
	
public void cartinsert(CartmainVO cartmain, CartsubVO cartsub);
	
	public CartmainVO readMainid(CartmainVO cartmain);
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public void deleteSub(CartsubVO cartsub);
	
	public void deleteMain(CartmainVO cartmain);
	
	public void updateSub(CartsubVO cartsub);
	
	public void cartdeleteAll(CartmainVO cartmain);

	public void deletesuball(CartmainVO cartmain);

	public int getCartTotal(CartmainVO cartmain);

	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);
}


