package com.bjit.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bjit.ecommerce.entity.User;
import com.bjit.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Page<User> getPaginatetUser(int page) {
		return userRepository.findAll(new PageRequest(page, 3));
	}
	
	public User getUserById(int userId) {
		return userRepository.findByUserId(userId);
	}
	
}
