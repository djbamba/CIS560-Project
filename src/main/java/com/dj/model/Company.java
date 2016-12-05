package com.dj.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "company")
public class Company implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	protected int id;
	
	@Column(name = "name", nullable = false, unique = true)
	protected String name;
	
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
	@JoinTable(name = "company_country", joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"))
	protected Country country;
	
	public Company() {
		super();
	}
	
	public Company(String name) {
		super();
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
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Country getCountry() {
		return country;
	}
	
}
