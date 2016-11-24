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
public class GameSystem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("gameId")
	private long gameId; // foreign key for id in Game
	
	@JsonProperty("systemId")
	private long systemId; // foreign key for id in System
	
	public GameSystem() {
		
	}
	
	public GameSystem(long gameId, long systemId) {
		this.gameId = gameId;
		this.systemId = systemId;
	}
	
	@JsonProperty("gameId")
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	@JsonProperty("gameId")
	public long getGameId() {
		return gameId;
	}
	
	@JsonProperty("systemId")
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	}
	
	@JsonProperty("systemId")
	public long getSystemId() {
		return systemId;
	}
	
	@Override
	public String toString() {
		return String.format("gameId: %l systemId: %l", gameId, systemId);
	}
	
}
