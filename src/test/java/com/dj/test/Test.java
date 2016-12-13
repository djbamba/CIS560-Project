package com.dj.test;

import com.dj.model.Developer;
import com.dj.model.Game;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.PurchaseWebsite;
import com.dj.model.System;
import com.dj.utils.pages.BingPage;
import com.dj.utils.pages.WikiPage;
import com.dj.utils.pages.WikiResultsPage;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

/**
 * Created by DJ on 11/9/16.
 */

@RunWith(JUnitParamsRunner.class)
public class Test {
	
	private static final Logger LOG = LogManager.getLogger(Test.class);
	
	private static WebDriver driver;
	
	private static WikiPage wikiPage;
	
	private static BingPage bingPage;

//	private static WikiResultsPage wikiResults;
	
	@BeforeClass
	public static void setup() {
		java.lang.System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		wikiPage = new WikiPage(driver);
		bingPage = new BingPage(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	
	public static void systemExtraction(WikiResultsPage wikiResults) {
		try {
			List<System> systems = wikiResults.getPlatforms();
			
			systems.forEach(system -> {
				LOG.info(system.toString());
			});
			
		} catch (Exception e) {
			LOG.error("Error in systemExtraction:", e);
		}
	}
	
	public static void developerExtraction(WikiResultsPage wikiResults) {
		try {
			Developer developer = wikiResults.getDeveloper();
			LOG.info(developer.toString());
			
		} catch (Exception e) {
			LOG.error("Error in developerExtraction:", e);
		}
	}
	
	public static void designerExtraction(WikiResultsPage wikiResultsPage) {
		try {
			String designer = wikiResultsPage.getDesigner();
			LOG.info("Designer: {}", designer);
		} catch (Exception e) {
			LOG.error("Error in designerExtraction:", e);
		}
	}
	
	public static void genreExtraction(WikiResultsPage wikiResults) {
		try {
			List<Genre> genres = wikiResults.getGenres();
			
			genres.forEach(genre -> {
				LOG.info(genre.toString());
			});
			
		} catch (Exception e) {
			LOG.error("Error in genreExtraction:", e);
		}
	}
	
	public static void urlExtraction(WikiResultsPage wikiResults) {
		try {
			String url = wikiResults.getImageSource();
			LOG.info("URL: {}", url);
		} catch (Exception e) {
			LOG.error("Error in urlExtraction:", e);
		}
	}
	
	public static void publisherExtraction(WikiResultsPage wikiResults) {
		try {
			Publisher publisher = wikiResults.getPublisher();
			LOG.info(publisher.toString());
			
		} catch (Exception e) {
			LOG.error("Error in publisherExtraction:", e);
		}
	}
	
	public static void scoreExtraction(WikiResultsPage wikiResults) {
		try {
			wikiResults.getScoreWebsiteInfo();
			
		} catch (Exception e) {
			LOG.error("Error in scoreExtraction:", e);
		}
	}
	
	@org.junit.Test
	@FileParameters(value = "src/main/resources/data/games.csv", mapper = CsvWithHeaderMapper.class)
	public static void gameInfoExtractionTest(String id, String name, String date, String url) {
		
		try {
			LOG.info("id: {} name: {} date: {} url: {}", id, name, date, url);
			WikiResultsPage wikiResults = wikiPage.searchGame(name).getWikiResultsPage();
//			// test systems extraction
//			systemExtraction(wikiResults);
//			// test developer extraction
//			developerExtraction(wikiResults);
//			//test designer extraction
//			designerExtraction(wikiResults);
//			// test genre extraction
//			genreExtraction(wikiResults);
//			// test url extraction
//			urlExtraction(wikiResults);
//			// test publisher extraction
//			publisherExtraction(wikiResults);
//			test score extraction
			scoreExtraction(wikiResults);
		} catch (Exception e) {
			LOG.error("Exception in gameInfoExtractionTest", e);
		}
	}
	
	@org.junit.Test
	@FileParameters(value = "src/main/resources/data/games.csv", mapper = CsvWithHeaderMapper.class)
	public static void gamePurchaseSiteTest(String id, String name, String date, String url) {
		List<PurchaseWebsite> sites;
		Game test = new Game(name, date);
		sites = bingPage.searchGame(test).getPurchaseWebsites();
		
		sites.forEach(site -> LOG.info(site.toString()));
	}
}
