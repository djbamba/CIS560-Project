package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
@DiscriminatorValue(value = "DEV")
public class Developer extends Company {
	
	@Column(name = "lead_designer", nullable = false)
	@JsonProperty("leadDesigner")
	private String leadDesigner;
	
	public Developer() {
		super();
	}
	
	public Developer(String name, String leadDesigner) {
		super(name);
		this.leadDesigner = leadDesigner;
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
		return String.format("Developer[id: %l name: %s leadDesigner: %s]", super.getId(), super.getName(), leadDesigner);
	}
	
}

