package com.dj.repository;

import com.dj.model.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 * CREATE TABLE GAME (ID INT PRIMARY KEY, NAME VARCHAR(225), RELEASE_DATE VARCHAR(225), IMAGE_URL VARCHAR(225));
 */
//INSERT INTO game SELECT id, name, release_date, image_url from CSVREAD('./src/main/resources/data/games.csv');
// insert into game ("ID", "IMAGE_URL","NAME","RELEASE_DATE")  select "ID", "IMAGE_URL","NAME","RELEASE_DATE" from csvread('./src/main/resources/data/games.csv')
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	Game findById(Integer id);

	Game findByName(String name);
	
	List<Game> findByNameContaining(String name);
	
	List<Game> findByNameOrderByRelease(String name);
	
	Game findById(int id);
}
