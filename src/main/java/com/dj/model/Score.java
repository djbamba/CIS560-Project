package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
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
	@JsonProperty("id")
	private int id; // primary key
	
	@ManyToOne
	@JoinColumn(name = "website_name",referencedColumnName = "name")
	@JsonProperty("website")
	private Website website; // foreign key to id in Website
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	@JsonProperty("game")
	private Game game; // foreign key to id in Games
	
	@JsonProperty("score")
	private int score;
	
	@JsonProperty("scoreType")
	private char scoreType;
	
	public Score() {
		
	}
	
	public Score(Website website, Game game, int score, char scoreType) {
		this.website = website;
		this.game = game;
		this.score = score;
		this.scoreType = scoreType;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	
	@JsonProperty("website")
	public void setWebsite(Website website) {
		this.website = website;
	}
	
	@JsonProperty("website")
	public Website getWebsite() {
		return website;
	}
	
	@JsonProperty("game")
	public void setGame(Game game) {
		this.game = game;
	}
	
	@JsonProperty("game")
	public Game getGame() {
		return game;
	}
	
	@JsonProperty("score")
	public void setScore(int score) {
		this.score = score;
	}
	
	@JsonProperty("score")
	public int getScore() {
		return score;
	}
	
	@JsonProperty("scoreType")
	public void setScoreType(char scoreType) {
		this.scoreType = scoreType;
	}
	
	@JsonProperty("scoreType")
	public char getScoreType() {
		return scoreType;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l websiteName: %s gameId: %s score: %d scoreType: %c",
		                     id, website.toString(), game.toString(), score, scoreType);
	}
}
