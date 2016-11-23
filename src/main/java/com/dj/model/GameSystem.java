package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by DJ on 11/10/16.
 */
public class GameSystem {
	
	@JsonProperty(value = "gameId")
	private long gameId; // foreign key for id in Game
	
	@JsonProperty(value = "systemId")
	private long systemId; // foreign key for id in System
	
	public GameSystem() {
		
	}
	
	public GameSystem(long gameId, long systemId) {
		this.gameId = gameId;
		this.systemId = systemId;
	}
	
	@JsonProperty(value = "gameId")
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	@JsonProperty(value = "gameId")
	public long getGameId() {
		return gameId;
	}
	
	@JsonProperty(value = "systemId")
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	}
	
	@JsonProperty(value = "systemId")
	public long getSystemId() {
		return systemId;
	}
	
	@Override
	public String toString() {
		return String.format("gameId: %l systemId: %l", gameId, systemId);
	}
	
}
