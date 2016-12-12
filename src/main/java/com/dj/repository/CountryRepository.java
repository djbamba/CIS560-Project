package com.dj.repository;

import com.dj.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DJ on 11/23/16.
 */
// INSERT INTO COUNTRY SELECT * FROM CSVREAD('./src/main/resources/data/countries2.csv');
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	Country findByName(String name);
	
	Country findByCode(String code);
}
