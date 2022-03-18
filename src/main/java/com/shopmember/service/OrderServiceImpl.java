package com.shopmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmember.mapper.CartMapper;
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
	private OrderMapper ordermapper; 
	
	@Setter(onMethod_ = @Autowired) 
	private CartMapper cartmapper;
	
	@Override
	public OrdermainVO orderproc(CartmainVO cartmain) {
		// cm_code 를 사용하여 장바구니 sub 조회
		// 주문 main_insert
		// cm_code 조회
		// 주문 sub에 insert
		// 장바구니 sub 삭제(cm_code 활용)
		// 장바구니 main 삭제(cm_code 활용)
		// om_code를 반환
		
		OrdermainVO ordermain = new OrdermainVO();
		ordermain.setM_id(cartmain.getM_id());
		ordermapper.insertMain(ordermain);
		ordermain = ordermapper.readMainid(ordermain);
		
		List<CartsubVO> cartsub = cartmapper.getListCart(cartmain);
		for(CartsubVO item :  cartsub) {
			OrdersubVO ordersub = new OrdersubVO();
			ordersub.setOm_code(ordermain.getOm_code());
			ordersub.setP_code(item.getP_code());
			ordersub.setOs_cnt(item.getCs_cnt());
			ordermapper.insertSub(ordersub);
		}
		cartmapper.deleteSub(cartmain); 
		cartmapper.deleteMain(cartmain);
		
		return ordermain;
	}
	
	@Override
	public List<OrderdetailDTO> getListCartDetail(OrdermainVO ordermain) {
		return ordermapper.getListOrderDetail(ordermain);
	}
}
