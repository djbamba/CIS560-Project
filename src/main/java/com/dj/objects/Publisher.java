package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/15/16.
 */
public class Publisher extends Company {
	
	@JsonProperty(value = "contentRating")
	private String contentRating;
	
	public Publisher() {
		super();
	}
	
	public Publisher(long id, String name, String contentRating) {
		super(id, name);
		this.contentRating = contentRating;
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
		                     super.getId(), super.getName(), contentRating);
	}
	
	
	
}
