package com.dj.repository;

import com.dj.model.Developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
	
	Developer findByName(String name);

	List<Developer> findByNameContaining(String name);
}
