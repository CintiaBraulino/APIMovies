package com.lead.dell.movies.entities;

import java.io.Serializable;
<<<<<<< HEAD
=======

>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
<<<<<<< HEAD
@Table(name="category")
=======
@Table(name="CATEGORY")
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
<<<<<<< HEAD
	private Long id;
=======
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	
	private String name;
	
	private String tag;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

<<<<<<< HEAD
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

=======
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	
}

