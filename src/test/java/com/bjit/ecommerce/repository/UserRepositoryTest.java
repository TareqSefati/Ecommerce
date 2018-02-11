package com.bjit.ecommerce.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bjit.ecommerce.EcommerceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EcommerceApplication.class)
@WebAppConfiguration
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUserIdTest() {
		
	}
}
