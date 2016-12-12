package com.dj.controller;

import com.dj.model.Country;
import com.dj.model.Developer;
import com.dj.model.Game;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.Score;
import com.dj.model.ScoreWebsite;
import com.dj.model.System;
import com.dj.repository.CountryRepository;
import com.dj.repository.DeveloperRepository;
import com.dj.repository.GameRepository;
import com.dj.repository.GenreRepository;
import com.dj.repository.PublisherRepository;
import com.dj.repository.ScoreRepository;
import com.dj.repository.ScoreWebsiteRepository;
import com.dj.repository.SystemRepository;
import com.dj.utils.MetaScraper;
import com.dj.utils.pages.*;
import com.dj.utils.repoutils.RepoUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 11/24/16.
 */

@RestController
@RequestMapping(value = "seed")
public class SeedController {
	
	private static final Logger LOG = LogManager.getLogger(SeedController.class);
	
	private WebDriver driver;
	
	private StringBuilder sb = new StringBuilder();
	
	public void config() {
		// pointing selenium's firefox driver to an older version of firefox since the newer versions aren't supported anymore.
		java.lang.System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
	}
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private SystemRepository systemRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private ScoreWebsiteRepository scoreWebsiteRepository;
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@RequestMapping(value = "/meta/{pageNumber}", produces = "application/json")
	@ResponseBody
	public String populateGames(@PathVariable(value = "pageNumber") String pageNumber) {
		
		ObjectMapper mapper = new ObjectMapper();
		List<Game> games = MetaScraper.getPage(pageNumber);
		StringBuilder sb = new StringBuilder();
		
		for (Game game : games) {
			
			try {
				gameRepository.save(game);
			} catch (ConstraintViolationException cve) {
				LOG.error("Constraint Violation Exception", cve);
				continue;
			} catch (DataIntegrityViolationException dive) {
				LOG.error("Data Integrity Violation Exception", dive);
				continue;
			} catch (Exception e) {
				LOG.error("Exception Thrown", e);
				continue;
			}
		}
		
		games = gameRepository.findAll();
		
		games.forEach(gameConsumer -> {
			try {
				sb.append(mapper.writeValueAsString(gameConsumer) + "\n");
			} catch (JsonProcessingException e) {
				LOG.error("Json Processing Exception", e);
			}
		});
		
		return sb.toString();
	}
	
	@RequestMapping(value = "/google/{searchGame}", produces = "text/html")
	public String searchGoogle(@PathVariable(value = "searchGame") String searchText) {
		
		config();
		String shredded = null;
		
		try {
			String splitSearch = searchText.replace("_", " ");
			GooglePage googlePage = new GooglePage(driver);
			googlePage.searchGame(splitSearch);
			GoogleResultsPage resultsPage = googlePage.getGoogleResultsPage();
			shredded = resultsPage.shredBlock();
			resultsPage.close();
		} catch (Exception e) {
			LOG.error("Exception in Google pages", e);
		}
		return shredded;
	}
	
	@RequestMapping(value = "/wiki/{searchGame}", produces = "text/html")
	public String searchWiki(@PathVariable(value = "searchGame") String searchText) {
		
		config();
		sb.delete(0, sb.length());
		List<System> systems;
		Developer developer;
		
		try {
			
			String splitSearch = searchText.replace("_", " ");
			WikiPage wikiPage = new WikiPage(driver);
			wikiPage.searchGame(splitSearch);
			WikiResultsPage resultsPage = wikiPage.getWikiResultsPage();
			sb.append(resultsPage.shredBlock() + "\n");
			
			systems = resultsPage.getPlatforms();
			systems.forEach(system -> {
				sb.append(system.toString() + "\n");
			});
			
			developer = resultsPage.getDeveloper();
			LOG.info(developer.toString());
			
			LOG.info("Image src: {}", resultsPage.getImageSource());
			
			resultsPage.close();
		} catch (Exception e) {
			LOG.error("Exception in Wiki pages", e);
		}
		
		return sb.toString();
	}
	
	@RequestMapping("/populate")
	public void populate() {
//		drop table developer, game_genres, game_purchase_website, game_score_website, genre, publisher, purchase_website, score, score_website,system,game_system,genre_games
		// TODO: 12/12/16 stop duplicate entries for genre-games...
		List<Game> allGames = gameRepository.findAll();
		config();
		WikiPage wikiPage = new WikiPage(driver);
		WikiResultsPage resultsPage = null;
		
		Country country;
		Publisher pub;
		Developer dev;
		ScoreWebsite tempScoreWebsite;
		Score tempScore;
		List<String[]> scoreWebsiteInfo;
		List<Genre> genres;
		List<System> systems;
		List<Score> scores = new ArrayList<>();
		List<ScoreWebsite> scoreWebsites = new ArrayList<>();
		
		try {
			
			for (Game game : allGames) {
				resultsPage = wikiPage.searchGame(game.getName()).getWikiResultsPage();
//				extract info from resultsPage
				genres = resultsPage.getGenres();
				systems = resultsPage.getPlatforms();
				pub = resultsPage.getPublisher();
				dev = resultsPage.getDeveloper();
//				check info against their repositories
				genres = RepoUtils.checkGenres(genres, genreRepository);
				systems = RepoUtils.checkSystems(systems, systemRepository);
				pub = RepoUtils.checkPublisher(pub, publisherRepository);
				dev = RepoUtils.checkDeveloper(dev, developerRepository);
//				country = RepoUtils.checkCountry(dev.getCountry(), countryRepository);
//				country.addDeveloper(dev);
				
//				country = RepoUtils.checkCountry(pub.getCountry(), countryRepository);
//				country.addPublisher(pub);
//				build ScoreWebsite & Score
				scoreWebsiteInfo = resultsPage.getScoreWebsiteInfo();
				
				for (String[] info : scoreWebsiteInfo) {
					LOG.info("Score Website info: {}", info.toString());
					tempScoreWebsite = RepoUtils.checkScoreWebsite(new ScoreWebsite(info[0], info[1]), scoreWebsiteRepository);
					tempScore = new Score(tempScoreWebsite, game, info[2]);
					tempScoreWebsite.addScore(tempScore);
					scores.add(tempScore);
					scoreWebsites.add(tempScoreWebsite);
				}
//				insert game into related info
				pub.addGame(game);
				dev.addGame(game);
				genres.forEach(genre -> genre.addGame(game));
				systems.forEach(system -> system.addGame(game));
				scoreWebsites.forEach(scoreWebsite -> scoreWebsite.addGame(game));
//				save game related info
				genres = genreRepository.save(genres);
				systems = systemRepository.save(systems);
				pub = publisherRepository.save(pub);
				dev = developerRepository.save(dev);
				scoreWebsites = scoreWebsiteRepository.save(scoreWebsites);
				scores = scoreRepository.save(scores);
//				insert all info into game
				game.setPublisher(pub);
				game.setDeveloper(dev);
				game.addGenres(genres);
				game.addScoreWebsites(scoreWebsites);
				game.addScores(scores);
				game.addSystems(systems);
//				save game in repository
				gameRepository.save(game);
//				clear lists
				scoreWebsites.clear();
				scoreWebsiteInfo.clear();
				scores.clear();
				genres.clear();
				systems.clear();
			}
			resultsPage.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/populateCountries")
	public void populateCountries() {
		File file = new File("src/main/resources/data/countries.csv");
		BufferedReader br;
		FileInputStream fis;
		InputStreamReader isr;
		
		String line;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) {
				String[] split = line.split(",");
				// 0 = name, 1 = code
				Country country = new Country(split[1], split[0]);
				countryRepository.save(country);
			}
			
			List<Country> countries = countryRepository.findAll();
			for (Country country : countries) {
				LOG.debug("Country: " + country.toString());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/populateCompanies", method = RequestMethod.GET)
	public void populateCompanies() {
		File developersCSV = new File("src/main/resources/data/developers.csv");
		BufferedReader br;
		FileInputStream fis;
		InputStreamReader isr;
		
		String line;
		try {
			fis = new FileInputStream(developersCSV);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) {
				String[] split = line.split(";");
				String name = split[0];
				String country = split[1];
				LOG.info("Country: " + country + ", " + country.length());
				LOG.info(country);
				Country countryObject = countryRepository.findByName(country);
				if (countryObject != null)
					LOG.info(countryObject.getCode());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
