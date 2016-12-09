package com.dj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // primary key
	
	@ManyToOne
	@JoinColumn(name = "website_name", referencedColumnName = "name")
	private Website website; // foreign key to name in Website
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game; // foreign key to id in Games
	
	private String score;
	
	public Score() {
		
	}
	
	public Score(Website website, Game game, String score) {
		this.website = website;
		this.game = game;
		this.score = score;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setWebsite(Website website) {
		this.website = website;
	}
	
	public Website getWebsite() {
		return website;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return String.format("Score[id: %d websiteName: %s gameId: %s score: %s ]",
		                     id, website.toString(), game.toString(), score);
	}
}
