package com.bjit.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.ecommerce.entity.User;

@RestController
public class RestUserController {

//    @PostMapping(value="/admin/userManager/getUsers", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//             headers="charset=UTF-8,content-type=text/plain")
//    @ResponseBody
//    public String getAllRestUsers(HttpServletRequest request) {
//    	
//    	User user1 = new User(1, "aaaaaaa", "bbbbbb", "aaaa@ss.com", "std12345", "111111111", "active",
//    			"dhaka dhaka", "dhaka dhaka", 2, "1212", "dhaka dhaka", "dhaka dhaka", 2, "1212", new Date(), new Date());
////    	System.out.println(user);
////    	user.setUserId(120);
////    	user.setUserCreatedOn(new Date());
////    	user.setUserUpdatedOn(new Date());
////    	System.out.println(user);
////    	if(result.hasErrors()) {
////    		System.out.println(result.getAllErrors());
////    		return ResponseEntity.ok(errors);
////    	} else {
////    		return ResponseEntity.ok(user);
////    	}
//    	return request.getParameter("firstName");
//        
//
//    }
	
//	@GetMapping(value="/admin/userManager/getUsers")
//	public String getAllRestUsers() {
//		System.out.println("hi there.");
//		return null;
//	}
	
//	@PostMapping(value="/admin/userManager/getUsers")
//	public ResponseEntity<User> getAllRestUsers(@Valid User user, BindingResult result) {
//		System.out.println("hi there." + user);
//		if(result.hasErrors()) {
//			System.out.println("has error");
//			return ResponseEntity.ok(null);
//		}else {
//			System.out.println("Found Data.");
//			return ResponseEntity.ok(user);
//		}
//	}
	
	@PostMapping(value="/admin/userManager/getUsers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			headers="\"Content-Type\": \"application/json; charset=UTF-8\"")
	@ResponseBody
	public ResponseEntity<?> getAllRestUsers(@RequestBody  User user, BindingResult result, Errors errors) {
		System.out.println("hi there.:  " + user);
		if(result.hasErrors()) {
			System.out.println("has error");
			return ResponseEntity.ok(errors);
		}else {
			System.out.println("Found Data.");
			return ResponseEntity.ok(user);
			//return ResponseEntity.ok(user);
		}
		//return null;
	}
	
}




