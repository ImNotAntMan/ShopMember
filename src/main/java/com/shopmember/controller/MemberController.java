package com.shopmember.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmember.myapp.MemberVO;
import com.shopmember.myapp.PageDTO;
import com.shopmember.myapp.ShippingVO;
import com.shopmember.service.MemberService;
import com.shopmember.service.ShippingService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/")
public class MemberController {

	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@Setter(onMethod_ = @Autowired)
	private ShippingService shippingservice;	// 배송지 관리를 위한 서비스
	
	@GetMapping("/info")
	public String getList(Model model, HttpSession session) {
		String m_id = (String) session.getAttribute("m_id");
		MemberVO member = new MemberVO();
		member.setM_id(m_id);
//		m_id = "dummy";
		log.info(m_id + "님 ");
		if(m_id == null) {
			return "redirect:/member/login";
		} else {
			model.addAttribute("member",service.read(member));
			return "/member/info";			
		}
	}
	
	@GetMapping("/read")
	public String read(Model model, HttpSession session, PageDTO page) {
		String m_id = (String) session.getAttribute("m_id");
		log.info(m_id + "님 이러면 안되지~~~");
		if(m_id == null) {
			return "redirect:/member/login";
		} else {
			MemberVO member = new MemberVO();
			ShippingVO shipping = new ShippingVO();
			shipping.setM_id(m_id);
			member.setM_id(m_id);
			log.info(shipping);
			model.addAttribute("member", service.read(member));
			model.addAttribute("list", shippingservice.getList(shipping));
			log.info(shippingservice.getList(shipping));
			log.info("read에요");
			return "/member/read";
		}
	}
	
	@GetMapping("/insert")
	public void insert(MemberVO member) {
		
	}
	
	@PostMapping("/insert")
	public String insert(MemberVO member, PageDTO page) {
		service.insert(member);
		return "redirect:/member/list?pageNum=" + page.getPageNum();
	}
	
	@GetMapping("/update")
	public void update(MemberVO member, Model model, PageDTO page) {
		member =  service.read(member);
		log.info(member);
		model.addAttribute("member", member);
		model.addAttribute("pageNum", page.getPageNum());
	}
	
	@PostMapping("/update")
	public String update(MemberVO member, PageDTO page, Model model) {
		service.update(member);
		return "redirect:/member/read?m_id=" + member.getM_id() + "&pageNUm=" + page.getPageNum();
	}
	
	@GetMapping("/delete")
	public String delete(MemberVO member) {
		service.delete(member);
		return "redirect:/member/list";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(MemberVO member, HttpSession session) {
		log.info(member);
//		System.out.println(member);
		boolean chk = service.auth(member);
		if(chk == true) {
			member = service.read(member);
			log.info("인증성공");
			System.out.println(member);
			System.out.println("LogIn Success~~~~");
			session.setAttribute("m_id", member.getM_id());
			session.setAttribute("m_name", member.getM_name());
			return "redirect:/member/read";
		} else {
			log.info("인증실패");
			System.out.println("LogIn Failed");
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();//세션 끊기
		System.out.println("LogOut Success");
		return "redirect:/";
	}
	
	@GetMapping("/shippinginsert")
	public void shipinginsert(Model model, HttpSession session) {
		String m_id = (String) session.getAttribute("m_id");
		model.addAttribute("m_id", m_id);
	}
	
	@PostMapping("/shippinginsert")
	public String shippinginsert(ShippingVO shipping) {
		shippingservice.insert(shipping);
		return "redirect:/member/zipcode?m_id=" + shipping.getM_id();
	}
	
	@GetMapping("/test")
	public void shippingupdate(ShippingVO shipping, Model model) {
		log.info("좋은것~!! test");
		shipping = shippingservice.readnum(shipping);
		log.info(shipping);
		model.addAttribute("list", shipping);
	}

	@PostMapping("/shippingupdate")
	public String shippingupdate(ShippingVO shipping) {
		shippingservice.update(shipping);
		log.info(shipping);
		log.info("_________________________________");
		return "redirect:/member/read?m_id=" + shipping.getM_id();
	}
	
	@GetMapping("/shippingdelete")
	public String shippingdelete(ShippingVO shipping) {
		shippingservice.delete(shipping);
		return "redirect:/member/zipcode?m_id=" + shipping.getM_id();
	}
	
	@GetMapping("/zipcode")
	public void zipcode(ShippingVO shipping, Model model) {
		log.info(shippingservice.getList(shipping));
		model.addAttribute("list", shippingservice.getList(shipping));
	}
}
