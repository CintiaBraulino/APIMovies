package com.lead.dell.movies.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity 
@Table (name="users", uniqueConstraints= {@UniqueConstraint(columnNames= {"cpf","email"})})	
public class User implements Serializable, UserDetails{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Column(unique = true, nullable = false)
	private String cpf;
	
	@NotEmpty
	@Column(unique = true, nullable = false)
	private String phone_number;
	
	@NotEmpty
	@Column(unique = true, nullable = false)
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Profile> profile = new ArrayList<>();
	
	private boolean activite = true;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getCpf(){
		return cpf;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public String getPhone_number(){
		return phone_number;
	}

	public void setPhone_number(String phone_number){
		this.phone_number = phone_number;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public List<Profile> getProfile() {
		return profile;
	}
	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}
	
	public Language getLanguage(){
		return language;
	}

	public void setLanguage(Language language){
		this.language = language;
	}
	public boolean isActivite(){
		return activite;
	}
	public void setActivite(boolean activite){
		this.activite = activite;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profile;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}