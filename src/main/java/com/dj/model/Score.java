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
	
	private int score;
	
	private char scoreType;
	
	public Score() {
		
	}
	
	public Score(Website website, Game game, int score, char scoreType) {
		this.website = website;
		this.game = game;
		this.score = score;
		this.scoreType = scoreType;
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
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScoreType(char scoreType) {
		this.scoreType = scoreType;
	}
	
	public char getScoreType() {
		return scoreType;
	}
	
	@Override
	public String toString() {
		return String.format("Score[id: %d websiteName: %s gameId: %s score: %d scoreType: %c]",
		                     id, website.toString(), game.toString(), score, scoreType);
	}
}
