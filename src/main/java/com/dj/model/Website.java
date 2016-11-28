package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Website {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("url")
	private String url;
	
	@ManyToMany(mappedBy = "websites")
	@JsonProperty("games")
	private Set<Game> games;
	
	@OneToMany(mappedBy = "website")
	private Set<Score> scores;
	
	public Website() {
		
	}
	
	public Website(String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
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
	
	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}
	
	@JsonProperty("games")
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	@JsonProperty("games")
	public Set<Game> getGames() {
		return games;
	}
	
	@JsonProperty("scores")
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	
	@JsonProperty("scores")
	public Set<Score> getScores() {
		return scores;
	}
	
	@Override
	public String toString() {
		return String.format("name: %s url: %s", name, url);
	}
}

