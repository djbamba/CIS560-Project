package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Company implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	@JsonProperty("name")
	private String name;
	
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
	@JoinTable(name = "company_country", joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"))
	@JsonProperty("country")
	private Country country;
	
	public Company() {
		super();
	}
	
	public Company(String name) {
		super();
		this.name = name;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("country")
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@JsonProperty("country")
	public Country getCountry() {
		return country;
	}
	
}
