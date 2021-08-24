package com.lead.dell.movies.entities;

import java.io.Serializable;
<<<<<<< HEAD
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

=======

import javax.persistence.Entity;
import javax.persistence.Table;
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
<<<<<<< HEAD
@Table(name="Movies")
=======
@Table(name="MOVIES")
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f

	public class Movie implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private Long id;
		
		private String title;
		
		private String synopsis;
		
		private String image;
		
<<<<<<< HEAD
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private LocalDate releaseDate;	
=======
		private String releaseDate;	
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
		
		private String duration;
			
		@ManyToOne
		@JoinColumn(name = "language_id")
		private Language language;
<<<<<<< HEAD
/*
		@ManyToOne
		@JoinColumn(name = "category_id")
		private Category category;
*/		
=======

>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSynopsis() {
			return synopsis;
		}

		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
<<<<<<< HEAD
	
		public LocalDate getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(LocalDate releaseDate) {
=======

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
			this.releaseDate = releaseDate;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public Language getLanguage() {
			return language;
		}

		public void setLanguage(Language language) {
			this.language = language;
<<<<<<< HEAD
		}
/*
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}	*/	
		
=======
		}			
>>>>>>> 33cdee9563f43703479b83c5d3656206f964f83f
	
}