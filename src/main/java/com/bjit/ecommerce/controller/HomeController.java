package com.bjit.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
		return "homee";
	}
	
	
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin";
	}
}
