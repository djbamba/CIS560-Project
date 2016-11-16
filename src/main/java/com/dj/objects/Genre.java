package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class Genre {
	
	@JsonProperty(value = "id")
	private long id; // primary key
	
	@JsonProperty(value = "genre")
	private String genre;
	
	public Genre() {
		
	}
	
	public Genre(long id, String genre) {
		this.id = id;
		this.genre = genre;
	}
	
	@JsonProperty(value = "id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty(value = "id")
	public long getId() {
		return id;
	}
	
	@JsonProperty(value = "genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@JsonProperty(value = "genre")
	public String getGenre() {
		return genre;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l genre: %s", id, genre);
	}
	
}
