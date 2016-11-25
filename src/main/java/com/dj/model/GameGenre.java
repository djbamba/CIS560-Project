package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "game_genre")
public class GameGenre {
	
	@Id
	@Column(name = "id", nullable = false)
	@JsonProperty("gameId")
	private int gameId; // foreign key for id in Game
	@Column(name = "genre_id",nullable = false)
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
