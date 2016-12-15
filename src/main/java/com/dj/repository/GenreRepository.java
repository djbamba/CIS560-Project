package com.dj.repository;

import com.dj.model.Game;
import com.dj.model.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

	List<Genre> findAllByOrderByGenre();

	Genre findByGenre(String name);

	List<Genre> findByGenreContaining(String name);
}
