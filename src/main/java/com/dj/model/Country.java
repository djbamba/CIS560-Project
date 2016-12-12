package com.dj.model;

import java.util.ArrayList;
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
	
	/***	relations ***/
	@OneToMany(mappedBy = "country", targetEntity = Developer.class)
	private List<Developer> developers = new ArrayList<>();
	
	@OneToMany(mappedBy = "country", targetEntity = Publisher.class)
	private List<Publisher> publishers = new ArrayList<>();
	
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
	
//	public void addCompany(Company company) {
//		companies.add(company);
//	}
	
	public void addDeveloper(Developer developer) {
		developers.add(developer);
	}
	
	public void addPublisher(Publisher publisher) {
		publishers.add(publisher);
	}
	
//	public void setCompanies(List<Company> companies) {
//		this.companies = companies;
//	}
//
//	public List<Company> getCompanies() {
//		return companies;
//	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}
	
	public List<Publisher> getPublishers() {
		return publishers;
	}
	
	@Override
	public String toString() {
		return String.format("Country[code: %s name: %s]", code, name);
	}
}
