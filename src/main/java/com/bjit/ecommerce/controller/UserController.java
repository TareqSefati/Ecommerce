package com.bjit.ecommerce.controller;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjit.ecommerce.entity.User;
import com.bjit.ecommerce.response.UpdatingUserResponse;
import com.bjit.ecommerce.response.UserPageResponse;
import com.bjit.ecommerce.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//***Getting User Manager Page
	@GetMapping("/admin/userManager")
	public String userManagerPage(User user, Model model, @RequestParam(defaultValue="0") int page) {
//		List<User> userList = userService.getAllUsers();
//		model.addAttribute("userList", userList);
		System.out.println("Page number is: " + page);
		model.addAttribute("user", user);
		model.addAttribute("userList", userService.getPaginatetUser(page));
		model.addAttribute("currentPage", page);
		
		return "userManager";
	}
	
	//***Manage User by ajax response
	@GetMapping("/admin/userManagerAjax")
	@ResponseBody
	public UserPageResponse userManagerPageAjax(HttpSession session, Model model, @RequestParam("page") int page) {
		if(session.getAttribute("user") == null) {
			session.setAttribute("user", new User());
		}
		
//		System.out.println("Page number is: " + page);
//		model.addAttribute("userList", userService.getPaginatetUser(page));
//		model.addAttribute("currentPage", page);
		
		UserPageResponse response = new UserPageResponse();
		response.setcurrentPage(page);
		response.setPageUser(userService.getPaginatetUser(page));
		
		return response;
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
	//***Getting user by id
	@GetMapping("/getUserById/")
	@ResponseBody
	public User updatingUser(int userId, Model model, User user) {
		return userService.getUserById(userId);
	}
	
	//***Updating a user
	@PostMapping(value="/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public UpdatingUserResponse updateUser(@Valid User user, BindingResult result) {
		//System.out.println("BACK END: User is updating-> "+userId);
		UpdatingUserResponse response = new UpdatingUserResponse();
		System.out.println(user);
		//following operation should be update
		if(result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream().collect(
					Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
					);
			//System.out.println(errors);
			response.setErrorMessages(errors);
			response.setValidated(false);
		}else {
			response.setUser(user);
			response.setValidated(true);
		}
		return response;
	}
	
	//***Login controller
	@PostMapping("/login")
	public User userLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "  "+ password);
		return null;
	}
	
//	@GetMapping("/admin/userManager/getUsers")
//	public String getAllUsers() {
//		jsonob
//		return "giving User List.";
//	}
	
}
