package com.dj.controller;

import com.dj.model.Game;
import com.dj.repository.GameRepository;
import com.dj.utils.MetaScraper;
import com.dj.utils.pages.GoogleHomePage;
import com.dj.utils.pages.GoogleResultsPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.h2.jdbc.JdbcSQLException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DJ on 11/24/16.
 */

@RestController
@RequestMapping(value = "seed")
public class SeedController {
	
	private static final Logger LOG = LogManager.getLogger(SeedController.class);
	private WebDriver driver;
	
	@Autowired
	private GameRepository gameRepository;
	
	@RequestMapping(value = "/meta/{pageNumber}", produces = "application/json")
	public
	@ResponseBody
	String populateGames(@PathVariable(value = "pageNumber") String pageNumber) {
		ObjectMapper mapper = new ObjectMapper();
		List<Game> games = MetaScraper.getPage(pageNumber);
		StringBuilder sb = new StringBuilder();
		
		for (Game game : games) {
			try {
				gameRepository.save(game);
			} catch (ConstraintViolationException cve) {
				continue;
			} catch (DataIntegrityViolationException dive) {
				continue;
			} catch (Exception e) {
				continue;
			}
		}
		
		games = gameRepository.findAll();
		games.forEach(game -> {
			try {
				sb.append(mapper.writeValueAsString(game) + "\n");
			} catch (JsonProcessingException jpe) {
				jpe.printStackTrace();
			}
		});
//			mapper.writeValueAsString(games);
//		games.stream().forEach(game -> System.out.println(game.toString()));
		return sb.toString();
	}
	
	@RequestMapping(value = "/google/{searchText}", produces = "text/html")
	public String searchGoogle(@PathVariable(value = "searchText") String searchText) {
		System.setProperty("webdriver.firefox.bin","/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		String splitSearch = searchText.replace("_"," ");
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		googleHomePage.searchText(splitSearch);
		GoogleResultsPage resultsPage = googleHomePage.submit();
		
		return resultsPage.shredBlock();
	}
	
	
}
