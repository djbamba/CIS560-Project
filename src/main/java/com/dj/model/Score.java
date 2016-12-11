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
	private ScoreWebsite scoreWebsite; // foreign key to name in ScoreWebsite
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game; // foreign key to id in Games
	
	private String score;
	
	public Score() {
		
	}
	
	public Score(ScoreWebsite scoreWebsite, Game game, String score) {
		this.scoreWebsite = scoreWebsite;
		this.game = game;
		this.score = score;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setScoreWebsite(ScoreWebsite scoreWebsite) {
		this.scoreWebsite = scoreWebsite;
	}
	
	public ScoreWebsite getScoreWebsite() {
		return scoreWebsite;
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
		                     id, scoreWebsite.toString(), game.toString(), score);
	}
}
