package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/15/16.
 */
public class Publisher implements Company {
	
	@JsonProperty(value = "id")
	private long id; // primary key
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "contentRating")
	private String contentRating;
	
	public Publisher() {
		
	}
	
	public Publisher(long id, String name, String contentRating) {
		this.id = id;
		this.name = name;
		this.contentRating = contentRating;
	}
	
	@JsonProperty(value = "id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty(value = "id")
	public long getId() {
		return id;
	}
	
	@JsonProperty(value = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty(value = "name")
	public String getName() {
		return name;
	}
	
	@JsonProperty(value = "contentRating")
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	
	@JsonProperty(value = "contentRating")
	public String getContentRating() {
		return contentRating;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s contentRating: %s",
		                     id, name, contentRating);
	}
	
	
}
