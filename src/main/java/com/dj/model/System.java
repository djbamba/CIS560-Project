package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class System {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // primary key
	
	@Column(unique = true)
	private String name;
	
	/***	relations ***/
//	@ManyToMany(targetEntity = Game.class, cascade = CascadeType.ALL)
//	@JoinTable(name = "game_system", joinColumns = @JoinColumn(name = "system_id", referencedColumnName = "id"),
//	 inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Game> games = new ArrayList<>();
	
	public System() {
		
	}
	
	public System(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	@Override
	public String toString() {
		return String.format("System[id: %d name: %s]", id, name);
	}
	
}
