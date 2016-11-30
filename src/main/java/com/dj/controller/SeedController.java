package com.dj.controller;

import com.dj.model.Developer;
import com.dj.model.Game;
import com.dj.repository.GameRepository;
import com.dj.utils.MetaScraper;
import com.dj.utils.pages.GooglePage;
import com.dj.utils.pages.GoogleResultsPage;
import com.dj.utils.pages.WikiPage;
import com.dj.utils.pages.WikiResultsPage;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
	}
	
	@Autowired
	private GameRepository gameRepository;
	
	
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
		List<com.dj.model.System> systems;
		List<Developer> developers;
		
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
			
			developers = resultsPage.getDevelopers();
			developers.forEach(developer -> {
				LOG.info(developer.toString());
			});
			
			LOG.info("Image src: {}", resultsPage.getImageSource());
			
			resultsPage.close();
		} catch (Exception e) {
			LOG.error("Exception in Wiki pages", e);
		}
		
		return sb.toString();
	}
	
	
}
