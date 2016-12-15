package com.dj.repository;

import com.dj.model.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	
	Publisher findByName(String name);

	List<Publisher> findByNameContaining(String name);
}
