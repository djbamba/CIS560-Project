package com.dj.objects;


import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;

/**
 * Created by DJ on 11/10/16.
 */

public class Game {
	
	@JsonProperty(value = "id")
	private long id;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "release")
	private String release;
	
	public Game() {
	}
	
	public Game(long id, String name, String release) {
		this.id = id;
		this.name = name;
		this.release = release;
	}
	
	@JsonProperty(value = "id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty(value = "id")
	public long getId() {
		return this.id;
	}
	
	@JsonProperty(value = "name")
	public String getName() {
		return this.name;
	}
	
	@JsonProperty(value = "release")
	public void setRelease(String release) {
		 this.release = release;
	}
	@JsonProperty(value = "release")
	public String getRelease() {
		return this.release;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s release: %s",
		                     id, name, release);
	}
}
