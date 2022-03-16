package com.shopmember.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartsubVO;
import com.shopmember.service.CartService;
import com.shopmember.service.MemberService;
import com.shopmember.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/shop/")
public class ShopController {

	@Setter(onMethod_ = @Autowired) 
	private ProductService serviceproduct;
	
	@Setter(onMethod_ = @Autowired)
	private MemberService memberservice; 
	
	@Setter(onMethod_ = @Autowired)
	private CartService cartservice;
	
	@GetMapping("/list")
	private void list(Model model) {
		model.addAttribute("list", serviceproduct.getList());
	}
	
	@GetMapping("/cart")
	private void cartsub(CartsubVO cartsub, Model model) {
		log.info(cartsub);
		model.addAttribute("cartsub", serviceproduct.read(cartsub));
	}
	
	@PostMapping("/cart")
	private String cartsub(CartsubVO cartsub, HttpSession session) {
		String m_id = (String) session.getAttribute("m_id");
		if(m_id != null) {
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartservice.cartinsert(cartmain, cartsub);
			return "redirect:/shop/cartinfo";   
		} else {
			return "redirect:/shop/member/login";
		}
	}
	
	@GetMapping("/cartinfo")
	public void cartinfo(CartsubVO cartsub, Model model, HttpSession session) {
		// 세션아이디를 이요해서 cm_code를 구하고
		// cm_code를 이요해서 getListCart를 조회해서 리스트 출력
		String m_id = (String) session.getAttribute("m_id");
		CartmainVO cartmain = new CartmainVO();
		//int cs = cartmain.getCm_code();
		CartsubVO cs = new CartsubVO();
		model.addAttribute("list",cs);
	}
}
