package com.dj.utils.repoutils;

import com.dj.model.Country;
import com.dj.model.Developer;
import com.dj.model.Game;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.PurchaseWebsite;
import com.dj.model.ScoreWebsite;
import com.dj.model.System;
import com.dj.repository.CountryRepository;
import com.dj.repository.DeveloperRepository;
import com.dj.repository.GameRepository;
import com.dj.repository.GenreRepository;
import com.dj.repository.PublisherRepository;
import com.dj.repository.PurchaseWebsiteRepository;
import com.dj.repository.ScoreWebsiteRepository;
import com.dj.repository.SystemRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 12/11/16.
 */
public class RepoUtils {
	
	public static Country checkCountry(Country country, CountryRepository countryRepository) {
		if (countryRepository.findByCode(country.getCode()) == null) {
			return countryRepository.save(country);
		}
		return countryRepository.findByCode(country.getCode());
	}
	
	public static Developer checkDeveloper(Developer developer, DeveloperRepository developerRepository) {
		if (developerRepository.findByName(developer.getName()) == null) {
			return developerRepository.save(developer);
		}
		Developer existingDeveloper = developerRepository.findByName(developer.getName());
		String designer;
		if ((designer = developer.getLeadDesigner()) != null) {
			existingDeveloper.setLeadDesigner(designer);
		}
		return existingDeveloper;
	}
	
	public static Game checkGame(Game game, GameRepository gameRepository) {
		if (gameRepository.findByName(game.getName()) == null) {
			return gameRepository.save(game);
		}
		return gameRepository.findByName(game.getName());
	}
	
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
	
	public static Publisher checkPublisher(Publisher publisher, PublisherRepository publisherRepository) {
		if (publisherRepository.findByName(publisher.getName()) == null) {
			return publisherRepository.save(publisher);
		}
		Publisher existingPublisher = publisherRepository.findByName(publisher.getName());
		String rating;
		if ((rating = publisher.getContentRating()) != null) {
			existingPublisher.setContentRating(rating);
		}
		return existingPublisher;
	}
	
	public static PurchaseWebsite checkPurchaseWebsite(PurchaseWebsite purchaseWebsite, PurchaseWebsiteRepository purchaseWebsiteRepository) {
		if (purchaseWebsiteRepository.findByName(purchaseWebsite.getName()) == null) {
			return purchaseWebsiteRepository.save(purchaseWebsite);
		}
		return purchaseWebsiteRepository.findByName(purchaseWebsite.getName());
	}
	
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
