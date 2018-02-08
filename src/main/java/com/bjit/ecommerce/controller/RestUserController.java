package com.bjit.ecommerce.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.ecommerce.entity.User;

@RestController
public class RestUserController {

    @GetMapping("/admin/userManager/getUsers")
    public ResponseEntity<User> getAllRestUsers() {

//        AjaxResponseBody result = new AjaxResponseBody();
//
//        //If error, just return a 400 bad request, along with the error message
//        if (errors.hasErrors()) {
//
//            result.setMsg(errors.getAllErrors()
//                        .stream().map(x -> x.getDefaultMessage())
//                        .collect(Collectors.joining(",")));
//
//            return ResponseEntity.badRequest().body(result);
//
//        }

//        List<User> users = userService.findByUserNameOrEmail(search.getUsername());
//        if (users.isEmpty()) {
//            result.setMsg("no user found!");
//        } else {
//            result.setMsg("success");
//        }
//        result.setResult(users);
    	
    	User user = new User(1, "aaaaaaa", "bbbbbb", "aaaa@ss.com", "std12345", "111111111", "active", "dhaka dhaka", "dhaka dhaka", 2, "1212", "dhaka dhaka", "dhaka dhaka", 2, "1212", new Date(), new Date());
    	
        return ResponseEntity.ok(user);

    }
}
