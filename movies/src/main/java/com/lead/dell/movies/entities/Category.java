package com.lead.dell.movies.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="category",uniqueConstraints= {
		@UniqueConstraint(columnNames= {"name","tag"})
		})

	public class Category implements Serializable{

		private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id; 
		
		@NotEmpty
		@Column(unique = true, nullable = false)
		private String name;
		
		@NotEmpty
		@Column(unique = true, nullable = false)
		private String tag;
	
		@ManyToOne
		@JoinColumn(name = "language_id")
		private Language language;
	
		private boolean active = true;

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

		public String getTag() {
			return tag;
		}

		public void setTag(String tag){
			this.tag = tag;
		}
		
		public Language getLanguage() {
			return language;
		}

		public void setLanguage(Language language){
			this.language = language;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
	
}
