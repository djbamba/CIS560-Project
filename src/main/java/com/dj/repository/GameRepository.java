package com.dj.repository;

import com.dj.model.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
	
	
}
