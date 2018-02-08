package com.bjit.ecommerce.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.ecommerce.entity.User;

@RestController
public class RestUserController {

    @PostMapping("/admin/userManager/getUsers")
    public ResponseEntity<?> getAllRestUsers(@Valid @RequestBody User user, BindingResult result, Errors errors) {
    	
    	User user1 = new User(1, "aaaaaaa", "bbbbbb", "aaaa@ss.com", "std12345", "111111111", "active", "dhaka dhaka", "dhaka dhaka", 2, "1212", "dhaka dhaka", "dhaka dhaka", 2, "1212", new Date(), new Date());
    	user.setUserId(120);
    	user.setUserCreatedOn(new Date());
    	user.setUserUpdatedOn(new Date());
    	if(result.hasErrors()) {
    		System.out.println(result.getAllErrors());
    		return ResponseEntity.ok(errors);
    	} else {
    		return ResponseEntity.ok(user);
    	}
        

    }
}
