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
public class ScoreWebsite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	@ManyToMany(mappedBy = "websites")
	private List<Game> games;
	
	@OneToMany(mappedBy = "website")
	private List<Score> scores;
	
	public ScoreWebsite() {
		
	}
	
	public ScoreWebsite(String name, String url) {
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
		return String.format("ScoreWebsite[id: %d name: %s url: %s]",id, name, url);
	}
}

