package com.dj.utils.repoutils;

import com.dj.model.Company;
import com.dj.model.Country;
import com.dj.model.Genre;
import com.dj.model.ScoreWebsite;
import com.dj.model.System;
import com.dj.repository.CompanyRepository;
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
	
	public static Company checkCompany(Company company, CompanyRepository companyRepository) {
		if (companyRepository.findByName(company.getName()) == null) {
			return companyRepository.save(company);
		}
		return companyRepository.findByName(company.getName());
	}
	
	public static Country checkCountry(Country country, CountryRepository countryRepository) {
		if (countryRepository.findByCode(country.getCode()) == null) {
			return countryRepository.save(country);
		}
		return countryRepository.findByCode(country.getCode());
	}
	
	// TODO: 12/11/16 developer, game
	
	public static Genre checkGenre(Genre genre, GenreRepository genreRepository) {
		if (genreRepository.findByGenre(genre.getGenre()) == null) {
			return genreRepository.save(genre);
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
	// TODO: 12/11/16 publisher, purchaseWebsite
	
	public static System checkSystem(System system, SystemRepository systemRepository) {
		if (systemRepository.findByName(system.getName()) == null) {
			return systemRepository.save(system);
		}
		return systemRepository.findByName(system.getName());
	}
	
	public static ScoreWebsite checkScoreWebsite(ScoreWebsite scoreWebsite, ScoreWebsiteRepository scoreWebsiteRepository) {
		if (scoreWebsiteRepository.findByName(scoreWebsite.getName()) == null) {
			return scoreWebsiteRepository.save(scoreWebsite);
		}
		return scoreWebsiteRepository.findByName(scoreWebsite.getName());
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
	
}
