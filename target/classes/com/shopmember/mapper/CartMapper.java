package com.shopmember.mapper;

import java.util.List;

import com.shopmember.myapp.CartdetailDTO;
import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;
import com.shopmember.myapp.OrdersubVO;

public interface CartMapper {
	public List<CartmainVO> getListMain();
	
	public List<CartsubVO> getListSub();
	
	public List<OrdersubVO> getListCart(CartmainVO cartmain);

	public CartmainVO readMain(CartmainVO cartmain);
	
	public CartsubVO readSub(CartsubVO cartsub);
	
	public CartsubVO readSubProduct(CartsubVO cartsub);
	
	public CartmainVO readMainid(CartmainVO cartmain);
	
	public void insertMain(CartmainVO cartmain);
	
	public void insertSub(CartsubVO cartsub);
	
	public void updateSub(CartsubVO cartsub);
	
	public void deleteMain(CartmainVO cartmain);
	
	public void deleteSub(CartmainVO cartmain);

	public void deleteSuball(CartmainVO cartmain);

	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);
	
	public int getCartTotal(CartmainVO cartmain);
	
}
