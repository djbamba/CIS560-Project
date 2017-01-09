package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "score_website")
public class ScoreWebsite extends Website {
	
	/***	relations ***/
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "website_score",joinColumns = @JoinColumn(name = "website_id"), inverseJoinColumns = @JoinColumn(name = "score_id"))
	private List<Score> scores;
	
	
	public ScoreWebsite() {
		super();
		scores = new ArrayList<>();
	}
	
	public ScoreWebsite(String name, String url) {
		super(name, url);
		scores = new ArrayList<>();
	}
	
	public void addScore(Score score) {
		this.scores.add(score);
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	@Override
	public String toString() {
		return String.format("ScoreWebsite[id: %d name: %s url: %s]", id, name, url);
	}
}

