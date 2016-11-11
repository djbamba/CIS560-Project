package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class Genre {
	
	@JsonProperty(value = "genreId")
	private long genreId;
	
	@JsonProperty(value = "genre")
	private String genre;
	
	public Genre() {
		
	}
	
	public Genre(long genreId, String genre) {
		this.genreId = genreId;
		this.genre = genre;
	}
	
	@JsonProperty(value = "genreId")
	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}
	
	@JsonProperty(value = "genreId")
	public long getGenreId() {
		return genreId;
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
		return String.format("genreId: %l genre: %s", genreId, genre);
	}
	
}
