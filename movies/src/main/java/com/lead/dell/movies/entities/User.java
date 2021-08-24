package com.lead.dell.movies.entities;
<<<<<<< HEAD

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
=======
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

<<<<<<< HEAD


@Entity 
@Table (name="users", uniqueConstraints= {
		@UniqueConstraint(columnNames= {"cpf","email"})
})
=======
@Entity
@Table(name="USER")
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	
	public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
<<<<<<< HEAD
	private Long id;
	
	@NotEmpty
	private String name;
	
	@Column(unique = true, nullable = false)
	private String cpf;
	
	@Column(unique = true, nullable = false)
	private String phone_number;
	
	@Column(unique = true, nullable = false)
=======
	
	private Long id;
	
	private String name;
	
	private String cpf;
	
	@Column(name = "phone_number")
	private String phone_number;
	
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	private String email;
	
	private String password;
	
	private String profile;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
<<<<<<< HEAD
	
	
=======

>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	public Long getId() {
		return id;
	}

<<<<<<< HEAD
	public void setId(long id) {
=======
	public void setId(Long id) {
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}