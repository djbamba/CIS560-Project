package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class GameSystem {
	
	@Id
	@JsonProperty("gameId")
	private int gameId; // foreign key for id in Game
	@JsonProperty("systemId")
	private int systemId; // foreign key for id in System
	
//	@ManyToMany
//	Game game;
//	System system;
	
	
	public GameSystem() {
		
	}
	
	public GameSystem(int gameId, int systemId) {
		this.gameId = gameId;
		this.systemId = systemId;
	}
	
	@JsonProperty("gameId")
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	@JsonProperty("gameId")
	public int getGameId() {
		return gameId;
	}
	
	@JsonProperty("systemId")
	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}
	
	@JsonProperty("systemId")
	public int getSystemId() {
		return systemId;
	}
	
	@Override
	public String toString() {
		return String.format("gameId: %l systemId: %l", gameId, systemId);
	}
	
}
