package com.bjit.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/admin/productManager")
	public String productManagerPage() {
		return "productManager";
	}
}
