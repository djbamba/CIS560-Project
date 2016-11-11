package com.dj.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;

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
	
	private static String metaSlug = "browse/games/score/metascore/all/all/filtered";//query string ?sort=desc&page=0
	
	private static int pageCount = 0;
	
	/**
	 * Method that checks the extracted text from the response body in getPage method.
	 * Will be adding all values to Game objects.
	 */
	public static void RegexCheck(String checkString) {
		
		final Pattern regex = Pattern.compile(GAME_REGEX);
		final Matcher regexMatcher = regex.matcher(checkString);
		
		List<String> info = new ArrayList<>();
		
		LOG.info("Game Text: {}", checkString);
		if (regexMatcher.find()) {
			LOG.info("Score: {}\n Title: {}\n System: {}\n User score: {}\n Release Date: {}\n",
			         regexMatcher.group(1),
			         regexMatcher.group(2),
			         regexMatcher.group(3),
			         regexMatcher.group(4),
			         regexMatcher.group(5));
		}
	}
	
	@Test
	public static void getPage() {
		//Make the request and get the response containing the HTML page.
		Response response;
		
		response = given().
		                   param("sort", "desc", "page", 0).
		                   baseUri(METACRITIC_URL).
		                   when().
		                   get(metaSlug).andReturn();
		
		//Extract the response body from the response object
		String body = response.getBody().prettyPrint();
		//Use Jsoup to create a DOM
		Document doc = Jsoup.parse(body);
		//Extract game elements from DOM
		List<Element> games = doc.select("div.product_row.game"); //select with css selector
		//Iterate through list and extract the values
		games.forEach(game -> RegexCheck(game.text().toString()));
	}
	
}
