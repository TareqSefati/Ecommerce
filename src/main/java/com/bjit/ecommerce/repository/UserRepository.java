package com.bjit.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bjit.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserId(int userId);
}
