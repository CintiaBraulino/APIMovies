package com.lead.dell.movies.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Profile implements Serializable, GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String nameProfile;
	
	
	public String getNameProfile() {
		return nameProfile;
	}

	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}
	

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nameProfile;
	}
	

}
