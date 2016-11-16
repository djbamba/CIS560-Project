package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by DJ on 11/10/16.
 */
public class GameGenre {
	
	@JsonProperty(value = "gameId")
	private long gameId; // foreign key for id in Game
	
	@JsonProperty(value = "genreId")
	private long genreId; // foreign key for id in Genre
	
	public GameGenre() {
		
	}
	
	public GameGenre(long gameId, long genreId) {
		this.gameId = gameId;
		this.genreId = genreId;
	}
	
	@JsonProperty(value = "gameId")
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	@JsonProperty(value = "gameId")
	public long getGameId() {
		return gameId;
	}
	
	@JsonProperty(value = "genreId")
	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}
	
	@JsonProperty(value = "genreId")
	public long getGenreId() {
		return genreId;
	}
	
	@Override
	public String toString() {
		return String.format("gameId: %l genreId: %l", gameId, genreId);
	}
}
