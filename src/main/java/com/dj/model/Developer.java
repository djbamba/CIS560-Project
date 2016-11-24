package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
public class Developer implements Company {
	
	@Id
	@JsonProperty("id")
	private long id; // primary key
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("leadDesigner")
	private String leadDesigner;
	
	public Developer() {
		
	}
	
	public Developer(long id, String name, String leadDesigner) {
		this.id = id;
		this.name = name;
		this.leadDesigner = leadDesigner;
	}
	
	
	@JsonProperty("id")
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	@Override
	public long getId() {
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
	
	@JsonProperty("leadDesigner")
	public void setLeadDesigner(String leadDesigner) {
		this.leadDesigner = leadDesigner;
	}
	
	@JsonProperty("leadDesigner")
	public String getLeadDesigner() {
		return leadDesigner;
	}
	
	@Override
	public String toString() {
		return String.format("id: %l name: %s leadDesigner: %s", id, name, leadDesigner);
	}
	
}

