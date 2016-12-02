package com.dj.model;

import java.util.List;

import javax.persistence.Column;
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
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "url", unique = true, nullable = false)
	private String url;
	
	@ManyToMany(mappedBy = "websites")
	private List<Game> games;
	
	@OneToMany(mappedBy = "website")
	private List<Score> scores;
	
	public Website() {
		
	}
	
	public Website(String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
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
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	@Override
	public String toString() {
		return String.format("Website[id: %d name: %s url: %s]",id, name, url);
	}
}

