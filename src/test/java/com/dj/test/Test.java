package com.dj.test;

import com.dj.model.System;
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
	
	private static WikiResultsPage wikiResults;
	
	@BeforeClass
	public static void setup() {
		java.lang.System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wikiPage = new WikiPage(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	
	@org.junit.Test
	public static void testSystemExtraction() {
		wikiResults = wikiPage.searchGame("Far Cry Primal").getWikiResultsPage();
		List<System> systems = wikiResults.getPlatforms();
		
		try {
			
			systems.stream().forEach(system -> {
				LOG.info(system.toString());
			});
			
		} catch (Exception e) {
			LOG.error("testSystemExtraction: {}", e);
		}
		
	}
	
	@org.junit.Test
	@FileParameters(value = "src/main/resources/data/games.csv", mapper = CsvWithHeaderMapper.class)
	public static void gameTest(String id, String name, String date, String url) {
		List<System> systems;
		
		try {
			LOG.info("id: {} name: {} date: {} url: {}", id, name, date, url);
		} catch (Exception e) {
			LOG.error("Exception in systemTest", e);
		}
	}
	
}
