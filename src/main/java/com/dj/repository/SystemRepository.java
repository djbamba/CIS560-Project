package com.dj.repository;

import com.dj.model.System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface SystemRepository extends JpaRepository<System, Integer> {
	
	System findByName(String name);

	List<System> findAllByOrderByName();

	List<System> findByNameContaining(String name);
}
