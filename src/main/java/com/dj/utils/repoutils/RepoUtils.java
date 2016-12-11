package com.dj.utils.repoutils;

import com.dj.model.Country;
import com.dj.model.Genre;
import com.dj.model.ScoreWebsite;
import com.dj.model.System;
import com.dj.repository.CountryRepository;
import com.dj.repository.GenreRepository;
import com.dj.repository.ScoreWebsiteRepository;
import com.dj.repository.SystemRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 12/11/16.
 */
public class RepoUtils {
	
	public static System checkSystem(System system, SystemRepository systemRepository) {
		System temp;
		if (systemRepository.findByName(system.getName()) == null) {
			temp = systemRepository.save(system);
			return temp;
		}
		return systemRepository.findByName(system.getName());
	}
	
	public static List<System> checkSystems(List<System> systems, SystemRepository systemRepository) {
		List<System> temps = new ArrayList<>();
		
		for (System system : systems) {
			if (systemRepository.findByName(system.getName()) == null) {
				temps.add(systemRepository.save(system));
			}
			temps.add(systemRepository.findByName(system.getName()));
		}
		return temps;
	}
	
	public static Genre checkGenre(Genre genre, GenreRepository genreRepository) {
		Genre temp;
		if (genreRepository.findByGenre(genre.getGenre()) == null) {
			temp = genreRepository.save(genre);
			return temp;
		}
		return genreRepository.findByGenre(genre.getGenre());
	}
	
	public static List<Genre> checkGenres(List<Genre> genres, GenreRepository genreRepository) {
		List<Genre> temps = new ArrayList<>();
		for (Genre genre : genres) {
			if (genreRepository.findByGenre(genre.getGenre()) == null) {
				temps.add(genreRepository.save(genre));
			}
			temps.add(genreRepository.findByGenre(genre.getGenre()));
		}
		return temps;
	}
	
	public static Country checkCountry(Country country, CountryRepository countryRepository) {
		Country temp;
		if (countryRepository.findByName(country.getName()) == null) {
			temp = countryRepository.save(country);
			return temp;
		}
		return countryRepository.findByName(country.getName());
	}
	
	public static ScoreWebsite checkScoreWebsite(ScoreWebsite scoreWebsite, ScoreWebsiteRepository scoreWebsiteRepository) {
		ScoreWebsite temp;
		if (scoreWebsiteRepository.findByName(scoreWebsite.getName()) == null) {
			temp = scoreWebsiteRepository.save(scoreWebsite);
			return temp;
		}
		return scoreWebsiteRepository.findByName(scoreWebsite.getName());
	}
	
}
