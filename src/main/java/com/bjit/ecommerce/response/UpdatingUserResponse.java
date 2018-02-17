package com.bjit.ecommerce.response;

import java.util.Map;

import com.bjit.ecommerce.entity.User;

public class UpdatingUserResponse {

	private User user;
	private Map<String, String> errorMessages;
	private boolean validated;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
}
