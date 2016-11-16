package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class Country {
	
	@JsonProperty(value = "code")
	private String code; // primary key
	
	@JsonProperty(value = "name")
	private String name;
	
	public Country() {
		
	}
	
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	@JsonProperty(value = "code")
	public void setCode(String code) {
		this.code = code;
	}
	@JsonProperty(value = "code")
	public String getCode() {
		return code;
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
		return String.format("code: %s name: %s", code, name);
	}
}
