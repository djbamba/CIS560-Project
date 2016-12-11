package com.dj.utils.repoutils;

import com.dj.model.Country;
import com.dj.model.Genre;
import com.dj.model.System;
import com.dj.repository.CountryRepository;
import com.dj.repository.GenreRepository;
import com.dj.repository.SystemRepository;

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
	
	public static Genre checkGenre(Genre genre, GenreRepository genreRepository) {
		Genre temp;
		if (genreRepository.findByGenre(genre.getGenre()) == null) {
			temp = genreRepository.save(genre);
			return temp;
		}
		return genreRepository.findByGenre(genre.getGenre());
	}
	
	public static Country checkCountry(Country country, CountryRepository countryRepository) {
		Country temp;
		if (countryRepository.findByName(country.getName()) == null) {
			temp = countryRepository.save(country);
			return temp;
		}
		return countryRepository.findByName(country.getName());
	}
	
}
