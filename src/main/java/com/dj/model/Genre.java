package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private long id; // primary key
	
	@JsonProperty("genre")
	private String genre;
	
	public Genre() {
		
	}
	
	public Genre(long id, String genre) {
		this.id = id;
		this.genre = genre;
	}
	
	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public long getId() {
		return id;
	}
	
	@JsonProperty("genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@JsonProperty("genre")
	public String getGenre() {
		return genre;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l genre: %s", id, genre);
	}
	
}
