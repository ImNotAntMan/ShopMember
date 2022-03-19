package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartmemberDTO;
import com.shopmember.myapp.CartsubVO;

public interface CartService { 
	
public void cartinsert(CartmainVO cartmain, CartsubVO cartsub);
	
	public CartmainVO readMainid(CartmainVO cartmain);
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public String deleteSub(CartsubVO cartsub);
	
	public void deleteMain(CartmainVO cartmain);
	
	public String updateSub(CartsubVO cartsub);
	
	public void cartdeleteAll(CartmainVO cartmain);

	public Object getListCartDetail(CartmainVO cartmain);

	public CartmemberDTO getCartTotal(CartmainVO cartmain);}


