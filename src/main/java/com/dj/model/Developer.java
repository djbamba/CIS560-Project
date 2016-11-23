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
	@Column(name = "id")
	@JsonProperty(value = "id")
	private long id; // primary key
	
	@Column(name = "name", unique = true, nullable = false)
	@JsonProperty(value = "name")
	private String name;
	
	@Column(name = "lead_designer",nullable = false)
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

