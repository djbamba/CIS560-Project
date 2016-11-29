package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
@DiscriminatorValue(value = "PUB")
public class Publisher extends Company {
	
	@JsonProperty("contentRating")
	private String contentRating;
	
	public Publisher() {
		super();
	}
	
	public Publisher(String name, String contentRating) {
		super(name);
		this.contentRating = contentRating;
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
		return String.format("Publisher[id: %d name: %s contentRating: %s]",
		                     super.getId(), super.getName(), contentRating);
	}
	
	
}
