package com.bjit.ecommerce.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjit.ecommerce.entity.User;
import com.bjit.ecommerce.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/userManager")
	public String userManagerPage(User user, Model model, @RequestParam(defaultValue="0") int page) {
//		List<User> userList = userService.getAllUsers();
//		model.addAttribute("userList", userList);
		System.out.println("Page number is: " + page);
		model.addAttribute("userList", userService.getPaginatetUser(page));
		model.addAttribute("currentPage", page);
		return "userManager";
	}
	
	@GetMapping("/userRegistration")
	public String userRegistrationPage(User user) {
		return "userRegistration";
	}
	
	@PostMapping("/addUser")
	public String addUser(@Valid User user, BindingResult result) {
	
		System.out.println(user);
		if(result.hasErrors()) {
			return "userRegistration";
		}else {
			//userService.addUser(user);
			user.setUserCreatedOn(new Date());
			user.setUserUpdatedOn(new Date());
			user.setUserStatus("inactive");
			System.out.println(user);
			
			try {
				userService.addUser(user);
			} catch (Exception e) {
				System.out.println("Unable to Register the User. "+ e.getMessage());
			}
			
			return "homee";
		}
	}
	
//	@GetMapping("/getUserBy/{userId}")
//	public void updatingUser(@PathVariable("userId") int userId, Model model) {
//		
//	}
	
	@GetMapping("/getUserBy/")
	@ResponseBody
	public User updatingUser(int userId, Model model, User user) {
		return userService.getUserById(userId);
	}
	
//	@GetMapping("/admin/userManager/getUsers")
//	public String getAllUsers() {
//		jsonob
//		return "giving User List.";
//	}
	
}
