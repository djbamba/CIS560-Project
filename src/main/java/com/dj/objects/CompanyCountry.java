package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class CompanyCountry {
	
	@JsonProperty(value = "companyId")
	private long companyId;
	
	@JsonProperty(value = "countryId")
	private long countryId;
	
	public CompanyCountry() {
		
	}
	
	public CompanyCountry(long companyId, long countryId) {
		this.companyId = companyId;
		this.countryId = countryId;
	}
	
	@JsonProperty(value = "companyId")
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	@JsonProperty(value = "companyId")
	public long getCompanyId() {
		return companyId;
	}
	
	@JsonProperty(value = "countryId")
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	
	@JsonProperty(value = "countryId")
	public long getCountryId() {
		return countryId;
	}
	
	@Override
	public String toString() {
		return String.format("companyId: %l countryId: %l", companyId, countryId);
	}
}
