package com.shopmember.mapper;

import java.util.List;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;

public interface CartMapper {
	public List<CartmainVO> getListMain();
	
	public List<CartsubVO> getListSub();
	
	public List<CartsubVO> getListCart();

	public CartmainVO readMain(CartmainVO cartmain);
	
	public CartsubVO readSub(CartsubVO cartsub);
	
	public CartsubVO readSubProduct(CartsubVO cartsub);
	
	public CartmainVO readMainid(CartmainVO cartmain);
	
	public void insertMain(CartmainVO cartmain);
	
	public void insertSub(CartsubVO cartsub);
	
	public void updateSub(CartsubVO cartsub);
	
	public void deleteMain(CartmainVO cartmain);
	
	public void deleteSub(CartsubVO cartsub);
	
}
