package com.dj.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
@DiscriminatorValue(value = "PUB")
public class Publisher extends Company {
	
	private String contentRating;
	
	public Publisher() {
		super();
	}
	
	public Publisher(String name, String contentRating) {
		super(name);
		this.contentRating = contentRating;
	}
	
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	
	public String getContentRating() {
		return contentRating;
	}
	
	@Override
	public String toString() {
		return String.format("Publisher[id: %d name: %s contentRating: %s]",
		                     id, name, contentRating);
	}
	
	
}
