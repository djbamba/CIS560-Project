package com.dj.repository;

import com.dj.model.Website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DJ on 11/23/16.
 */
@Repository
public interface WebsiteRepository extends JpaRepository<Website,Integer> {
	
}
