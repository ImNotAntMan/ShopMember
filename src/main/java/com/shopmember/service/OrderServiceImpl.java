package com.shopmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmember.mapper.OrderMapper;
import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;
import com.shopmember.myapp.OrderdetailDTO;
import com.shopmember.myapp.OrdermainVO;
import com.shopmember.myapp.OrdersubVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class OrderServiceImpl implements OrderService {

	@Setter(onMethod_ = @Autowired)
	private OrderMapper mapper;
	
	public void insertMain(OrdermainVO ordermain) {
		mapper.insertMain(ordermain);
	}
	
	@Override
	public void insertSub(OrdersubVO ordersub) {
		mapper.insertSub(ordersub);
	}
	
	@Override
	public List<OrdermainVO> getListMain(OrdermainVO ordermain){
		return mapper.getListMain(ordermain);
	}
	
	@Override  
	public OrdermainVO readMainid(OrdermainVO ordermaqin) {
		return mapper.readMainid(ordermaqin);
	}
	
	@Override
	public List<OrderdetailDTO> getListOrderDetail(OrdermainVO ordermain){
		return mapper.getListOrderDetail(ordermain);
	}
	
	@Override
	public OrdermainVO orderproc(CartmainVO cartmain) {
		return mapper.orderproc(cartmain);
	}
	
	@Override
	public List<OrderdetailDTO> getOrderTotal(CartmainVO cartmain) {
		return mapper.getOrderTotal(cartmain);
	}
	
	@Override
	public List<OrderdetailDTO> getListOrder(CartmainVO cartmain){
		return mapper.getListOrder(cartmain);
	}
	
	@Override
	public List<CartsubVO> getListCart(CartsubVO cartsub) {
		return mapper.getListCart(cartsub);
	}
	
	@Override
	public void deleteMain(OrdermainVO ordermain) {
		mapper.deleteMain(ordermain);
	}
	
	@Override
	public void deleteSub(OrdermainVO ordermain) {
		mapper.deleteSub(ordermain);
	}
}