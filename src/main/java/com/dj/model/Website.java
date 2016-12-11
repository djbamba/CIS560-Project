package com.dj.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by DJ on 12/10/16.
 */

//@Entity
//@Table(name = "Website")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Website{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "url", length = 400)
	protected String url;
	
	public Website() {}
	
	public Website(String name, String url) {
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
