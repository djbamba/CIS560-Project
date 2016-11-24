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
public class GameGenre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("gameId")
	private int gameId; // foreign key for id in Game
	
	@JsonProperty("genreId")
	private int genreId; // foreign key for id in Genre
	
	public GameGenre() {
		
	}
	
	public GameGenre(int gameId, int genreId) {
		this.gameId = gameId;
		this.genreId = genreId;
	}
	
	@JsonProperty("gameId")
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	@JsonProperty("gameId")
	public int getGameId() {
		return gameId;
	}
	
	@JsonProperty("genreId")
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	@JsonProperty("genreId")
	public int getGenreId() {
		return genreId;
	}
	
	@Override
	public String toString() {
		return String.format("gameId: %l genreId: %l", gameId, genreId);
	}
}
