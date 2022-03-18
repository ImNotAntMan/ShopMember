package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.OrderdetailDTO;
import com.shopmember.myapp.OrdermainVO;

public interface OrderService {
	
	public OrdermainVO orderproc(CartmainVO cartmain); 
	
	public List<OrderdetailDTO> getListCartDetail(OrdermainVO ordermain);
	
}
