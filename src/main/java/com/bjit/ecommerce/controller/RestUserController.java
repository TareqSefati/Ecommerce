package com.bjit.ecommerce.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.ecommerce.entity.User;

@RestController
public class RestUserController {

    @PostMapping(value="/admin/userManager/getUsers", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
             headers="charset=UTF-8,content-type=text/plain")
    @ResponseBody
    public ResponseEntity<?> getAllRestUsers(@Valid @RequestBody User user, BindingResult result, Errors errors) {
    	
    	User user1 = new User(1, "aaaaaaa", "bbbbbb", "aaaa@ss.com", "std12345", "111111111", "active", "dhaka dhaka", "dhaka dhaka", 2, "1212", "dhaka dhaka", "dhaka dhaka", 2, "1212", new Date(), new Date());
    	System.out.println(user);
    	user.setUserId(120);
    	user.setUserCreatedOn(new Date());
    	user.setUserUpdatedOn(new Date());
    	System.out.println(user);
    	if(result.hasErrors()) {
    		System.out.println(result.getAllErrors());
    		return ResponseEntity.ok(errors);
    	} else {
    		return ResponseEntity.ok(user1);
    	}
        

    }
}
