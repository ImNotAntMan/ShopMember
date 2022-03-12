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
import com.shopmember.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/")
public class MemberController {

	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
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
	public void read(Model model, HttpSession session) {
		String m_id = (String) session.getAttribute("m_id");
		log.info(m_id + "님");
		System.out.println(m_id + "님");
		MemberVO member = new MemberVO();
		member.setM_id(m_id);
		model.addAttribute("member", service.read(member));
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
		System.out.println(member);
		boolean chk = service.auth(member);
		if(chk == true) {
			member = service.read(member);
			log.info("인증성공");
			System.out.println("LogIn Success");
			session.setAttribute("m_id", member.getM_id());
			session.setAttribute("m_name", member.getM_name());
			return "redirect:/";
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
}
