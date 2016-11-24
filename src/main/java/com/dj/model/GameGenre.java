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
	private long gameId; // foreign key for id in Game
	
	@JsonProperty("genreId")
	private long genreId; // foreign key for id in Genre
	
	public GameGenre() {
		
	}
	
	public GameGenre(long gameId, long genreId) {
		this.gameId = gameId;
		this.genreId = genreId;
	}
	
	@JsonProperty("gameId")
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	@JsonProperty("gameId")
	public long getGameId() {
		return gameId;
	}
	
	@JsonProperty("genreId")
	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}
	
	@JsonProperty("genreId")
	public long getGenreId() {
		return genreId;
	}
	
	@Override
	public String toString() {
		return String.format("gameId: %l genreId: %l", gameId, genreId);
	}
}
