package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/15/16.
 */
public class Developer extends Company {
	
	@JsonProperty(value = "leadDesigner")
	private String leadDesigner;
	
	public Developer() {
		super();
	}
	
	public Developer(long id, String name, String leadDesigner) {
		super(id, name);
		this.leadDesigner = leadDesigner;
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
		return String.format("id: %l name: %s leadDesigner: %s", super.getId(), super.getName(), leadDesigner);
	}
	
}

