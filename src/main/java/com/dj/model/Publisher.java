package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
public class Publisher implements Company {
	
	@Id
	@Column(name = "id", unique = true)
	@JsonProperty(value = "id")
	private long id; // primary key
	
	@Column(name = "name", unique = true, nullable = false)
	@JsonProperty(value = "name")
	private String name;
	
	@Column(name = "content_rating")
	@JsonProperty(value = "contentRating")
	private String contentRating;
	
	public Publisher() {
		
	}
	
	public Publisher(String name, String contentRating) {
		this.name = name;
		this.contentRating = contentRating;
	}
	
	@JsonProperty(value = "id")
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty(value = "id")
	@Override
	public long getId() {
		return id;
	}
	
	@JsonProperty(value = "name")
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty(value = "name")
	@Override
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
