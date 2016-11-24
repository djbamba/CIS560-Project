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
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id; // primary key
	@JsonProperty("name")
	private String name;
	@JsonProperty("release")
	private String release;
	
	public Game() {
	}
	
	public Game(String name, String release) {
		this.name = name;
		this.release = release;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public int getId() {
		return this.id;
	}
	
	@JsonProperty("name")
	public String getName() {
		return this.name;
	}
	
	@JsonProperty("release")
	public void setRelease(String release) {
		 this.release = release;
	}
	@JsonProperty("release")
	public String getRelease() {
		return this.release;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d name: %s release: %s",
		                     id, name, release);
	}
}
