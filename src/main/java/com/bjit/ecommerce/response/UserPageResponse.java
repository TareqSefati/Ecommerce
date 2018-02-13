package com.bjit.ecommerce.response;

import org.springframework.data.domain.Page;

import com.bjit.ecommerce.entity.User;

public class UserPageResponse {
	private Page<User> pageUser;
	private int currentPage;
	public Page<User> getPageUser() {
		return pageUser;
	}
	public void setPageUser(Page<User> pageUser) {
		this.pageUser = pageUser;
	}
	public int getcurrentPage() {
		return currentPage;
	}
	public void setcurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
