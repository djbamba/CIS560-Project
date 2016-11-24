package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class CompanyCountry {
	
	@Id
	@JsonProperty("companyId")
	private int companyId; // foreign key to id in Company
	@JsonProperty("countryCode")
	private String countryCode; // foreign key to code in Country
	
	public CompanyCountry() {
		
	}
	
	public CompanyCountry(String countryCode) {
		this.companyId = companyId;
		this.countryCode = countryCode;
	}
	
	@JsonProperty("companyId")
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	@JsonProperty("companyId")
	public int getCompanyId() {
		return companyId;
	}
	
	@JsonProperty("countryCode")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@JsonProperty("countryCode")
	public String getCountryCode() {
		return countryCode;
	}
	
	@Override
	public String toString() {
		return String.format("companyId: %l countryCode: %l", companyId, countryCode);
	}
}
