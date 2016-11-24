package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private long id; // primary key
	
	@JsonProperty("websiteName")
	private String websiteName;
	
	@JsonProperty("gameId")
	private long gameId;
	
	@JsonProperty("score")
	private int score;
	
	@JsonProperty("scoreType")
	private char scoreType;
	
	public Score() {
		
	}
	
	public Score(long id, String websiteName, long gameId, int score, char scoreType) {
		this.id = id;
		this.websiteName = websiteName;
		this.gameId = gameId;
		this.score = score;
		this.scoreType = scoreType;
	}
	
	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public long getId() {
		return id;
	}
	
	@JsonProperty("websiteName")
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	
	@JsonProperty("websiteName")
	public String getWebsiteName() {
		return websiteName;
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
		                     id, websiteName, gameId, score, scoreType);
	}
}
