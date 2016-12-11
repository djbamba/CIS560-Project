package com.dj.repository;

import com.dj.model.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DJ on 12/10/16.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	Company findByName(String name);
}
