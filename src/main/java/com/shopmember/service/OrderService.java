package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.OrderdetailDTO;
import com.shopmember.myapp.OrdermainVO;
import com.shopmember.myapp.OrdersubVO;

public interface OrderService {

	public void insertMain(OrdermainVO ordermain); 
	
	public void insertSub(OrdersubVO ordersub);
	
	public List<OrdermainVO> getListMain(OrdermainVO ordermain);
	
	public OrdermainVO readMainid(OrdermainVO ordermaqin);
	
	public OrdermainVO orderproc(CartmainVO cartmain);
	
	public List<OrderdetailDTO> getOrderTotal(CartmainVO cartmain);
	
	public List<OrderdetailDTO> getListOrderDetail(OrdermainVO ordermain);
	
	public List<OrderdetailDTO> getListOrder(CartmainVO cartmain);
}
