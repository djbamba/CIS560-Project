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
public class System {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private long id; // primary key
	
	@JsonProperty("name")
	private String name;
	
	public System() {
		
	}
	
	public System(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public long getId() {
		return id;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s", id, name);
	}
	
}
