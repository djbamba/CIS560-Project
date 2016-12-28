package com.dj.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	}
	
	public ScoreWebsite(String name, String url) {
		super(name, url);
	}
	
	public void addScore(List<Score> scores) {
		this.scores.addAll(scores);
	}
	
	public List<Score> getScore() {
		return scores;
	}
	
	@Override
	public String toString() {
		return String.format("ScoreWebsite[id: %d name: %s url: %s]", id, name, url);
	}
}

