package com.shopmember.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmember.myapp.CartdetailDTO;
import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartmemberDTO;
import com.shopmember.myapp.CartsubVO;
import com.shopmember.myapp.OrdermainVO;
import com.shopmember.myapp.OrdersubVO;
import com.shopmember.myapp.ShippingVO;
import com.shopmember.service.CartService;
import com.shopmember.service.MemberService;
import com.shopmember.service.OrderService;
import com.shopmember.service.ProductService;
import com.shopmember.service.ShippingService;

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
	
	@Setter(onMethod_ = @Autowired)
	private ShippingService shippingservice;
	
	@Setter(onMethod_ = @Autowired) 
	private OrderService orderservice;

	
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
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/cartinfo")
	public String cartinfo(HttpSession session, Model model) {
		// 로그인 상태 확인 (제어구조(세션변수를 확인)를 먼저 만들어보자)
		String m_id = (String)session.getAttribute("m_id");
		String m_name = (String)session.getAttribute("m_name");
		if (m_id != null) {
		// 세션아이디를 이용해서 cm_code를 조회해야 함 / 로그인이 되어있다는 가정 하에 진행 
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartmain = cartservice.readMainid(cartmain);
			log.info(cartmain);
			if (cartmain == null) { // 로그인은 되었는데 cartmain(장바구니)이 있을수도 있고 없을 수도 있으니 확인해야 한다.
				log.info("장바구니 내용 없음");
				return "redirect:/shop/list";
			} else {
				// int cm_code = cartmain.getCm_code(); // 로그인된 사용자의 아이디를 사용하는 cartmain의 cm_code / 필요없어졌다.
				cartservice.getListCartDetail(cartmain).forEach(cartsub -> log.info(cartsub)); // 디버깅용으로 쓴거니까 주석
				model.addAttribute("list", cartservice.getListCartDetail(cartmain));
				CartmemberDTO cartmember = new CartmemberDTO();
				log.info(cartservice.getCartTotal(cartmain));
				cartmember.setCm_total(cartservice.getCartTotal(cartmain));
				cartmember.setCm_code(cartmain.getCm_code());
				cartmember.setM_name(m_name);
				cartmember.setM_id(m_id);
				System.out.println(cartmember);
				log.info(cartmember);
				model.addAttribute("cartmember", cartmember);
				model.addAttribute("cartmain", cartmain.getCm_code());	// cm_code 전달을 위해서....
				log.info("장바구니 내용 있음"); // cm_code를 통해 cartSub를 조회할거야
			}
		// cm_code를 이용해서 getListCart를 조회해서 리스트 출력
			log.info("로그인 상태");
			return "/shop/cartinfo";	// cartinfo 페이지로 이동(반드시 작성)
		} else {
			log.info("로그아웃 상태");
		}	return "/member/login";
	}

//	@GetMapping("/cartinfo")
//	public void cartinfo(CartsubVO cartsub, Model model, HttpSession session) {
//		// 세션아이디를 이요해서 cm_code를 구하고
//		// cm_code를 이요해서 getListCart를 조회해서 리스트 출력
//		String m_id = (String) session.getAttribute("m_id");
//		CartmainVO cartmain = new CartmainVO();
//		//int cs = cartmain.getCm_code();
//		CartsubVO cs = new CartsubVO();
//		model.addAttribute("list",cs);
//	}
	
	@PostMapping("/cartupdate")
	public String cartupdate(CartsubVO cartsub) {
		log.info("변경:" + cartsub);
		cartservice.updateSub(cartsub);
		return "redirect:/shop/cartinfo";
	}
	
	@GetMapping("/cartdelete")
	public String cartdelete(CartsubVO cartsub) {
		log.info(cartsub);
		cartservice.deleteSub(cartsub);
		return "redirect:/shop/cartinfo";
	}
	
	@GetMapping("/cartdeleteall")
	public String cartdeleteall(CartmainVO cartmain) {
		cartservice.deletesuball(cartmain);
		return "redirect:/shop/list";
	}
	
	@GetMapping("/orderprepare")
	public String orderprepare(HttpSession session, Model model) {
		String m_id = (String)session.getAttribute("m_id");
		String m_name = (String)session.getAttribute("m_name");
		if (m_id != null) {
		// 세션아이디를 이용해서 cm_code를 조회해야 함 / 로그인이 되어있다는 가정 하에 진행 
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartmain = cartservice.readMainid(cartmain);
			log.info(cartmain);
			if (cartmain == null) { // 로그인은 되었는데 cartmain(장바구니)이 있을수도 있고 없을 수도 있으니 확인해야 한다.
				log.info("장바구니 내용 없음");
				return "redirect:/shop/list";
			} else {
				OrdermainVO ordermain = new OrdermainVO();
				ordermain.setOm_code(cartmain.getCm_code());
				ordermain.setM_id(m_id);
				orderservice.insertMain(ordermain); //	영수증번호 보관하는 곳 
				OrdersubVO ordersub = new OrdersubVO();
				//cartservice.getListCartDetail(cartmain).forEach(cartsub -> log.info(cartsub)); // 디버깅용으로 쓴거니까 주석
				for(CartdetailDTO cart : cartservice.getListCartDetail(cartmain)) {
					log.info("쓰기시작");
					ordersub.setOm_code(cart.getCm_code());
					ordersub.setP_code(cart.getP_code());
					ordersub.setOs_cnt(cart.getCs_cnt());
					orderservice.insertSub(ordersub);
					log.info("쓰기성공");
				}
				model.addAttribute("list", cartservice.getListCartDetail(cartmain));
				CartmemberDTO cartmember = new CartmemberDTO();
				log.info(cartservice.getCartTotal(cartmain));
				cartmember.setCm_total(cartservice.getCartTotal(cartmain));
				cartmember.setCm_code(cartmain.getCm_code());
				cartmember.setM_name(m_name);
				cartmember.setM_id(m_id);
				System.out.println(cartmember);
				log.info(cartmember);
				cartservice.deleteSub(cartmain);
				cartservice.deleteMain(cartmain);
				ShippingVO shipping = new ShippingVO();
				shipping.setM_id(m_id);
				shipping = shippingservice.read(shipping);
				log.info("주문지:" + shipping);
				model.addAttribute("shipping", shipping);
				model.addAttribute("cartmember", cartmember);
				model.addAttribute("cartmain", cartmain.getCm_code());	// cm_code 전달을 위해서....
				log.info("장바구니 내용 있음"); // cm_code를 통해 cartSub를 조회할거야
			}
		// cm_code를 이용해서 getListCart를 조회해서 리스트 출력
			log.info("로그인 상태");
			return "/shop/orderprepare";	// cartinfo 페이지로 이동(반드시 작성)
		} else {
			log.info("로그아웃 상태");
		}	return "/member/login";
	}
	
	@GetMapping("/payment")
	public String payment(HttpSession session, Model model, CartmainVO cartmain) {
		String m_id = (String)session.getAttribute("m_id");
		String m_name = (String)session.getAttribute("m_name");
		if (m_id != null) {
		// 세션아이디를 이용해서 cm_code를 조회해야 함 / 로그인이 되어있다는 가정 하에 진행 
			cartmain.setM_id(m_id);
			cartmain = cartservice.readMainid(cartmain);
			log.info(cartmain);
			if (cartmain == null) { // 로그인은 되었는데 cartmain(장바구니)이 있을수도 있고 없을 수도 있으니 확인해야 한다.
				log.info("장바구니 내용 없음");
				return "redirect:/shop/list";
			} else {
				CartmemberDTO cartmember = new CartmemberDTO();
				log.info(cartservice.getCartTotal(cartmain));
				log.info("장바구니 내용 있음"); // cm_code를 통해 cartSub를 조회할거야
				String javascript = "<script>alert('"+ cartmember.getCm_total() + "원 결제하시겠습니까?')</script>"
						+ "<br>"
						+ "<a href='/shop/orderinfo'>확인</a>";
				model.addAttribute("script", javascript);
				String a =""
						+ "<html>"
						+ "<head>"
						+ "</head>"
						+ "<body>"
						+ "Hello!!!"
						+ "한글이 잘 되니?"
						+ "</body>"
						+ "</html>";
				model.addAttribute("a", a);
			}
		// cm_code를 이용해서 getListCart를 조회해서 리스트 출력
			log.info("로그인 상태");
			return "/shop/payment";	// cartinfo 페이지로 이동(반드시 작성)
		} else {
			log.info("로그아웃 상태");
		}	return "/member/login";
		
	}
	
	@GetMapping("/orderinfo")
	public String orderinfo(HttpSession session, Model model, CartmainVO cartmain) {
		String m_id = (String)session.getAttribute("m_id");
		if (m_id != null) {
			cartmain.setM_id(m_id);
			OrdermainVO ordermain = orderservice.orderproc(cartmain); // om_code 획득
			log.info(ordermain);
			model.addAttribute("list", orderservice.getListOrder(cartmain));
			model.addAttribute("total", orderservice.getOrderTotal(cartmain));
			log.info(cartmain);
			return "/shop/orderinfo";
		} else {
			log.info("로그인 필요");
			return "redirect:/member/login";
		}
	}
}
