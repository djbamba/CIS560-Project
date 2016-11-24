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
public class Developer implements Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id; // primary key
	@JsonProperty("name")
	private String name;
	@JsonProperty("leadDesigner")
	private String leadDesigner;
	
	public Developer() {
		
	}
	
	public Developer(String name, String leadDesigner) {
		this.id = id;
		this.name = name;
		this.leadDesigner = leadDesigner;
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

