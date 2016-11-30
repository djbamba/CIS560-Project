package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "genre")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id;
	
	@Column(name = "genre", nullable = false, unique = true)
	@JsonProperty("genre")
	private String genre;
	
	/*relations*/
	@ManyToMany(mappedBy = "genres")
	private List<Game> games;
	
	
	public Genre() {
		
	}
	
	public Genre(String genre) {
		this.genre = genre;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public int getId() {
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
	
	@JsonProperty("games")
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	@JsonProperty("games")
	public List<Game> getGames() {
		return games;
	}
	
	@Override
	public String toString() {
		return String.format("Genre[id: %d genre: %s]", id, genre);
	}
	
}
