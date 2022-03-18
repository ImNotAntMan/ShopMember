package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.CartdetailDTO;
import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartmemberDTO;
import com.shopmember.myapp.CartsubVO;

public interface CartService {
	
	public void cartinsert(CartmainVO cartmain, CartsubVO cartsub);

	public CartmainVO readMainid(CartmainVO cartmain);	
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);
	
	public CartmemberDTO getCartTotal(CartmainVO cartmain);
	
	public void updateSub(CartsubVO cartsub);
	
	public void deleteSub(CartsubVO cartsub);
	
	public CartmainVO readMain(CartmainVO cartmain);
	
	public void deleteMain(CartmainVO cartmain);
	
	public void deletesuball(CartmainVO cartmain);
}


