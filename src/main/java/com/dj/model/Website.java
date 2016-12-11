package com.dj.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by DJ on 12/10/16.
 */

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Website implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	protected String name;
	
	protected String url;
	
	public Website() {
		super();
	}
	
	public Website(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
}
