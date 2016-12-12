package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "score_website")
public class ScoreWebsite extends Website {
	
	/***	relations ***/
	@ManyToMany(mappedBy = "scoreWebsites")
	private List<Game> games = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scoreWebsite")
	private List<Score> scores = new ArrayList<>();
	
	public ScoreWebsite() {
		super();
	}
	
	public ScoreWebsite(String name, String url) {
		super(name, url);
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
	
	public void addScore(Score score) {
		scores.add(score);
	}
	
	public void setScore(List<Score> scores) {
		this.scores = scores;
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	@Override
	public String toString() {
		return String.format("ScoreWebsite[id: %d name: %s url: %s]", id, name, url);
	}
}

