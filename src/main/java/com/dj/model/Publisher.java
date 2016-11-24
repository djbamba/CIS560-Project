package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
public class Publisher implements Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id; // primary key
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("contentRating")
	private String contentRating;
	
	public Publisher() {
		
	}
	
	public Publisher(String name, String contentRating) {
		this.name = name;
		this.contentRating = contentRating;
	}
	
	@JsonProperty("id")
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	@Override
	public int getId() {
		return id;
	}
	
	@JsonProperty("name")
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("name")
	@Override
	public String getName() {
		return name;
	}
	
	@JsonProperty("contentRating")
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	
	@JsonProperty("contentRating")
	public String getContentRating() {
		return contentRating;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s contentRating: %s",
		                     id, name, contentRating);
	}
	
	
}
