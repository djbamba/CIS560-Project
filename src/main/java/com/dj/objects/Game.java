package com.dj.objects;


import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;

/**
 * Created by DJ on 11/10/16.
 */

public class Game {
	
	@Id
	@JsonProperty(value = "id")
	private int id;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "release")
	private String release;
	
	public Game() {
	}
	
	public Game(String name, String release) {
		this.name = name;
		this.release = release;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty(value = "id")
	public int getId() {
		return this.id;
	}
	
	@JsonProperty(value = "name")
	public String getName() {
		return this.name;
	}
	
	@JsonProperty(value = "release")
	public String getRelease() {
		return this.release;
	}
}
