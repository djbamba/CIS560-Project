package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class System {
	
	@JsonProperty(value = "systemId")
	private long systemId;
	
	@JsonProperty(value = "name")
	private String name;
	
	public System() {
		
	}
	
	public System(long systemId, String name) {
		this.systemId = systemId;
		this.name = name;
	}
	
	@JsonProperty(value = "systemId")
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	}
	
	@JsonProperty(value = "systemId")
	public long getSystemId() {
		return systemId;
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
		return String.format("systemId: %l name: %s", systemId, name);
	}
	
}
