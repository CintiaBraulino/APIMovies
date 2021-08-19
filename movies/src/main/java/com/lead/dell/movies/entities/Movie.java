package com.lead.dell.movies.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="MOVIES")

	public class Movie implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private Long id;
		
		private String title;
		
		private String synopsis;
		
		private String image;
		
		private String releaseDate;	
		
		private String duration;
			
		@ManyToOne
		@JoinColumn(name = "language_id")
		private Language language;

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

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
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
		}			
	
}