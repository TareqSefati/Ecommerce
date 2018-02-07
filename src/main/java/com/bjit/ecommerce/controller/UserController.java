package com.bjit.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/admin/userManager")
	public String userManagerPage() {
		return "userManager";
	}
}
