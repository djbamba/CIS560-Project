package com.dj.repository;

import com.dj.model.Website;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface WebsiteRepository extends CrudRepository<Website,Integer> {
	
}
