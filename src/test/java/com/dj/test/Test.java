package com.dj.test;

import com.dj.model.System;
import com.dj.utils.pages.WikiPage;
import com.dj.utils.pages.WikiResultsPage;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by DJ on 11/9/16.
 */

public class Test {
	
	private static final Logger LOG = LogManager.getLogger(Test.class);
	
	private static WebDriver driver;
	
	private static WikiPage wikiPage;
	
	private static WikiResultsPage wikiResults;
	
	public static void setup() {
		java.lang.System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wikiPage = new WikiPage(driver);
	}
	
	public static void tearDown() {
		driver.close();
	}
	
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
	
	public static void systemTest(int id, String name, String released, String url) {
		List<System> systems;
		
		try {
			
		} catch (Exception e) {
			LOG.error("Exception in systemTest", e);
		}
	}
	
}
