package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

/**
 * Created by DJ on 11/10/16.
 */
public class Score {
	
	@JsonProperty(value = "id")
	private long id;
	
	@JsonProperty(value = "websiteName")
	private String websiteName;
	
	@JsonProperty(value = "gameId")
	private long gameId;
	
	@JsonProperty(value = "score")
	private int score;
	
	@JsonProperty(value = "scoreType")
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
	
	@JsonProperty(value = "id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty(value = "id")
	public long getId() {
		return id;
	}
	
	@JsonProperty(value = "websiteName")
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	
	@JsonProperty(value = "websiteName")
	public String getWebsiteName() {
		return websiteName;
	}
	
	@JsonProperty(value = "score")
	public void setScore(int score) {
		this.score = score;
	}
	
	@JsonProperty(value = "score")
	public int getScore() {
		return score;
	}
	
	@JsonProperty(value = "scoreType")
	public void setScoreType(char scoreType) {
		this.scoreType = scoreType;
	}
	
	@JsonProperty(value = "scoreType")
	public char getScoreType() {
		return scoreType;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l websiteName: %s gameId: %s score: %d scoreType: %c",
		                     id, websiteName, gameId, score, scoreType);
	}
}
