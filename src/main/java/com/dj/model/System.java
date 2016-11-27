package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class System {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id; // primary key
	
	@Column(unique = true)
	@JsonProperty("name")
	private String name;
	
	@ManyToMany(mappedBy = "systems")
	private Set<Game> games;
	
	public System() {
		
	}
	
	public System(String name) {
		this.name = name;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("games")
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	@JsonProperty("games")
	public Set<Game> getGames() {
		return games;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s", id, name);
	}
	
}
