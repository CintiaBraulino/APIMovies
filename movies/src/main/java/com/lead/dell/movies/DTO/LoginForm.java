package com.lead.dell.movies.Dto;

public class LoginForm {
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public org.springframework.security.authentication.UsernamePasswordAuthenticationToken converter() {
		return new org.springframework.security.authentication.UsernamePasswordAuthenticationToken (email,password);
	}
	
	

}
