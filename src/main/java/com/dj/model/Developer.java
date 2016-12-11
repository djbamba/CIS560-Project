package com.dj.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
public class Developer extends Company {
	
	@Column(name = "lead_designer", nullable = false)
	private String leadDesigner;
	
	public Developer() {
		super();
	}
	
	public Developer(String name, String leadDesigner) {
		super(name);
		this.leadDesigner = leadDesigner;
	}
	
	public void setLeadDesigner(String leadDesigner) {
		this.leadDesigner = leadDesigner;
	}
	
	public String getLeadDesigner() {
		return leadDesigner;
	}
	
	@Override
	public String toString() {
		return String.format("Developer[id: %d name: %s leadDesigner: %s]", id, name, leadDesigner);
	}
	
}

