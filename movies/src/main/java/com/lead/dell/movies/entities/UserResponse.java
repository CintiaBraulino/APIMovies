package com.lead.dell.movies.entities;

public class UserResponse{
	
	private User user;
	private String message;
	
	public UserResponse(){	
	}
	
	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}
}
