package com.dj.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by DJ on 11/10/16.
 */


@MappedSuperclass
public abstract class Company{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	@Column(name = "name", unique = true)
	protected String name;
	
	public Company() {
		
	}
	
	public Company(String name) {
		this.name = name;
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
	
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//	public Country getCountry() {
//		return country;
//	}
	
}
