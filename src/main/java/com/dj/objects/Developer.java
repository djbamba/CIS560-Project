package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/15/16.
 */
public class Developer implements Company {
	
	@JsonProperty(value = "id")
	private long id; // primary key
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "leadDesigner")
	private String leadDesigner;
	
	public Developer() {
		
	}
	
	public Developer(long id, String name, String leadDesigner) {
		this.id = id;
		this.name = name;
		this.leadDesigner = leadDesigner;
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
	
	@JsonProperty(value = "leadDesigner")
	public void setLeadDesigner(String leadDesigner) {
		this.leadDesigner = leadDesigner;
	}
	
	@JsonProperty(value = "leadDesigner")
	public String getLeadDesigner() {
		return leadDesigner;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s leadDesigner: %s", id, name, leadDesigner);
	}
	
}

