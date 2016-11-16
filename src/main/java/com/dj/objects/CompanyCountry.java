package com.dj.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DJ on 11/10/16.
 */
public class CompanyCountry {
	
	@JsonProperty(value = "companyId")
	private long companyId; // foreign key to id in Company
	
	@JsonProperty(value = "countryCode")
	private long countryCode; // foreign key to code in Country
	
	public CompanyCountry() {
		
	}
	
	public CompanyCountry(long companyId, long countryCode) {
		this.companyId = companyId;
		this.countryCode = countryCode;
	}
	
	@JsonProperty(value = "companyId")
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	@JsonProperty(value = "companyId")
	public long getCompanyId() {
		return companyId;
	}
	
	@JsonProperty(value = "countryCode")
	public void setCountryCode(long countryCode) {
		this.countryCode = countryCode;
	}
	
	@JsonProperty(value = "countryCode")
	public long getCountryCode() {
		return countryCode;
	}
	
	@Override
	public String toString() {
		return String.format("companyId: %l countryCode: %l", companyId, countryCode);
	}
}
