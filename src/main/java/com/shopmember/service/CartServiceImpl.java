package com.shopmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmember.mapper.CartMapper;
import com.shopmember.myapp.CartdetailDTO;
import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;
import com.shopmember.myapp.OrdersubVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CartServiceImpl implements CartService {

	@Setter(onMethod_ = @Autowired) 
	private CartMapper mapper; 
	
	@Override
	public void cartinsert(CartmainVO cartmain, CartsubVO cartsub) {
		CartmainVO cm = new CartmainVO();
		cm = mapper.readMainid(cartmain);
		if(cm == null) {	// cartmain에 해당 사용자의 레코드 1개를 신규 생성해야 됨
			mapper.insertMain(cartmain);
			// cm_code가 생성되었으니 조회해서 알 수 있음
			cm = mapper.readMainid(cartmain);
			cartsub.setCm_code(cm.getCm_code());	// 조회한 신규 cm_code를 cartsub에 추가
			mapper.insertSub(cartsub);
		} else {	// 이미 최소 1개의 카트에 상품이 존재한다는 의미
			cartsub.setCm_code(cm.getCm_code());
			CartsubVO cs = new CartsubVO();
			cs = mapper.readSubProduct(cartsub);
			if(cs == null) {
				mapper.insertSub(cartsub);				
			} else {
				int tmp = cs.getCs_cnt() + cartsub.getCs_cnt();
				cs.setCs_cnt(tmp);
				log.info(cs);
				mapper.updateSub(cs);
			}
		}
	}
	
	@Override
	public List<OrdersubVO> getListCart(CartmainVO cartmain) {
		return mapper.getListCart(cartmain);
	}

	@Override
	public CartmainVO readMainid(CartmainVO cartmain) {
		return mapper.readMainid(cartmain);
	} 
	
	@Override
	public void deleteSub(CartmainVO cartmain) {
		log.info(cartmain);
		mapper.deleteSub(cartmain);
	}
	
	@Override
	public void updateSub(CartsubVO cartsub) {
		mapper.updateSub(cartsub);
	}
	
	@Override
	public void deleteMain(CartmainVO cartmain) {
		mapper.deleteMain(cartmain);
	}
	
	@Override
	public void cartdeleteAll(CartmainVO cartmain) {
		log.info(cartmain);
//		mapper.deleteSub(cartmain);
//		mapper.deleteMain(cartmain);
//		return "redirect:/shop/cartinfo";
	}
	
	@Override
	public void deletesuball(CartmainVO cartmain) {
		mapper.deleteSuball(cartmain);
	}
	
	@Override
	public int getCartTotal(CartmainVO cartmain) {
		return mapper.getCartTotal(cartmain);
	}
	
	@Override
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain) {
		return mapper.getListCartDetail(cartmain);
	}
}
