package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class System {
	
	@JsonProperty(value = "id")
	private long id; // primary key
	
	@JsonProperty(value = "name")
	private String name;
	
	public System() {
		
	}
	
	public System(long id, String name) {
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s", id, name);
	}
	
}
