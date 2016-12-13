package com.dj.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "score_website")
public class ScoreWebsite extends Website {
	
	/***	relations ***/
//	@ManyToMany(mappedBy = "scoreWebsites")
//	private List<Game> games = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Score score;
	
	public ScoreWebsite() {
		super();
	}
	
	public ScoreWebsite(String name, String url) {
		super(name, url);
	}
	
//	public void addGame(Game game) {
//		games.add(game);
//	}
	
//	public void setGames(List<Game> games) {
//		this.games = games;
//	}
	
//	public List<Game> getGames() {
//		return games;
//	}
	
	public void addScore(Score score) {
		this.score =score;
	}
	
//	public void addScore(List<Score> scores) {
//		this.scores = scores;
//	}
	
	public Score getScores() {
		return score;
	}
	
	@Override
	public String toString() {
		return String.format("ScoreWebsite[id: %d name: %s url: %s]", id, name, url);
	}
}

