package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by DJ on 11/10/16.
 */
public class Website {
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "url")
	private String url;
	
	public Website() {
		
	}
	
	public Website(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	@JsonProperty(value = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty(value = "name")
	public String getName() {
		return name;
	}
	
	@JsonProperty(value = "url")
	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonProperty(value = "url")
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return String.format("name: %s url: %s", name, url);
	}
}

