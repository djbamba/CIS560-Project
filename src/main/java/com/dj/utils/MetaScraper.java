package com.dj.utils;

import com.dj.model.Game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.response.Response;

import static com.dj.utils.ScraperConstants.*;
import static io.restassured.RestAssured.given;

/**
 * Created by DJ on 11/10/16.
 *
 * <p>notes: Regex: group(0) = entire string of groups that are matching the regex. groups(1-n) are
 * the individual capture groups.
 */
public class MetaScraper {
	
	private static final Logger LOG = LogManager.getLogger(MetaScraper.class);
	
	/**
	 * Method that checks the extracted text from the response body in getPage method.
	 * Will be adding all values to Game objects.
	 */
	public static Game RegexCheck(String checkString) {
		Game game = null;
		final Pattern regex = Pattern.compile(GAME_REGEX);
		final Matcher regexMatcher = regex.matcher(checkString);
		
		LOG.info("Game Text: {}", checkString);
		if (regexMatcher.find()) {
			LOG.info("Score: {}\n Title: {}\n System: {}\n User score: {}\n Release Date: {}\n",
			         regexMatcher.group(1),
			         regexMatcher.group(2),
			         regexMatcher.group(3),
			         regexMatcher.group(4),
			         regexMatcher.group(5));
			
			game = new Game(regexMatcher.group(2), regexMatcher.group(5));
		}
		
		return game;
	}
	
	public static List<Game> getPage(String page) {
		List<Game> allGames = new ArrayList<>();
		//Make the request and get the response containing the HTML page.
		Response response = given().
		                            baseUri(METACRITIC_URL).
		                            when().
		                            get("browse/games/score/metascore/all/all/filtered?sort=desc&page={page}",page).andReturn();
		
		//Extract the response body from the response object
		String body = response.getBody().prettyPrint();
		//Use Jsoup to create a DOM
		Document doc = Jsoup.parse(body);
		//Extract game elements from DOM with CSS selector
		List<Element> games = doc.select("div.product_row.game");
		//Iterate through list and extract the values and add them to the list
		games.forEach(game -> allGames.add(RegexCheck(game.text().toString())));
		
		return allGames;
	}
	
}
