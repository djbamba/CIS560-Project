package com.dj.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@Column(name = "code", unique = true, nullable = false)
	private String code; // primary key
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "country")
	private List<Company> companies;
	
	public Country() {
		
	}
	
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public List<Company> getCompanies() {
		return companies;
	}
	
	@Override
	public String toString() {
		return String.format("Country[code: %s name: %s]", code, name);
	}
}
