package com.ssafy.product.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.ProductDto;
import com.ssafy.product.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/list")
	public ModelAndView list(ProductDto product) throws SQLException {

		List<ProductDto> list = service.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", list);
		mv.setViewName("productlist");

		return mv;
	}

	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(ProductDto product) throws SQLException {
		System.out.println("상품등록할래포스트");
		service.regist(product);
		return "redirect:list";
	}
}
