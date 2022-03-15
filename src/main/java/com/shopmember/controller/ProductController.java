package com.shopmember.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.ProductVO;
import com.it.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/product/")
public class ProductController {

	@Setter(onMethod_ = @Autowired)
	private ProductService service;
	
	@GetMapping("/list")
	private void list(Model model) {
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/insert")
	private void insert() {
		
	}
	
	@PostMapping("/insert")
	private String insert(ProductVO product) {
		log.info(product);
		service.insert(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("/read")
	private void read(ProductVO product, Model model) {
		log.info(product);
		product = service.read(product);
		model.addAttribute("product", product);
	}
	
	@GetMapping("/update")
	private void update(ProductVO product, Model model) {
		product = service.read(product);
		model.addAttribute("product", product);
		
	}
	
	@PostMapping("/update")
	private String update(ProductVO product) {
		service.update(product);
		return "redirect:/product/read?p_code=" + product.getP_code();
	}
	
	@GetMapping("/delete")
	private String delete(ProductVO product) {
		service.delete(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("/imgupload")
	public void imgupload(ProductVO product, Model model) {
		log.info(product);
		model.addAttribute("p_code", product.getP_code());
	}
	
	@PostMapping("/imgupload")
	public void imgupload(HttpServletRequest request) {
		DiskFileUpload upload =  new DiskFileUpload();
		try {
			List items = upload.parseRequest(request);	// 웹브라우저 전송 객체 생성해서 업로드 컴포넌트에 전달
			Iterator params = items.iterator();	// 반복자 생성
			String imgpath = "C:\\myWorkSpace\\runJsp\\MySpring\\src\\main\\webapp\\resources\\product";
			String p_code = "";
			log.info(items);
			while(params.hasNext()) {	// form 객체가 있을 경우
				FileItem item = (FileItem)params.next();	// 폼 경식 객체를 변수에 저장
				if(item.isFormField()) {	// 파일 형식이 아니라면
					p_code = item.getString();	// 파일보다 먼저 반환 됨
				} else {	// 바이너리 파일이라면 
					File imgfile = new File(imgpath + "/" + p_code + ".jpg");	// 파일객체 생성
					item.write(imgfile);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
