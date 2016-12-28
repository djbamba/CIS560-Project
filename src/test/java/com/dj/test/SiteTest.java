package com.dj.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

/**
 * Created by DJ on 11/9/16.
 */

@RunWith(JUnitParamsRunner.class)
public class SiteTest {
	
	private static final Logger LOG = LogManager.getLogger(SiteTest.class);
	
	private static WebDriver driver;
	
	private static String baseUrl = "localhost:8080/";
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@org.junit.Test
	public void checkIndex() {
		driver.get(baseUrl);
		WebElement title = driver.findElement(By.className("title"));
		Assert.assertEquals("Title Matches", "GameScraper", title.getText());
	}
	
	@org.junit.Test
	public void checkGenre() {
		String genre = "Action";
		driver.get(baseUrl + "genre/" + genre);
		WebElement header = driver.findElement(By.xpath(".//h3[@class='ul-header']"));
		String actualHeader = header.getText();
		Assert.assertEquals("Genre header", genre, actualHeader);
	}
	
	@org.junit.Test
	public void checkGame() {
		String game = "Jet Grind Radio";
		driver.get(baseUrl + "game/" + game);
		WebElement header = driver.findElement(By.className("game-image-description"));
		String actualHeader = header.getText();
		Assert.assertEquals("Game header", game, actualHeader);
	}
	
	@org.junit.Test
	public void checkPublisher() {
		String sega = "Sega";
		driver.get(baseUrl + "publisher/" + sega);
		WebElement header = driver.findElement(By.className("ul-header"));
		String actualHeader = header.getText();
		Assert.assertEquals("Publisher header", sega, actualHeader);
	}
	
	@org.junit.Test
	public void checkDeveloper() {
		String visualConcepts = "Visual Concepts";
		driver.get(baseUrl + "developer/" + visualConcepts);
		WebElement header = driver.findElement(By.className("ul-header"));
		String actualHeader = header.getText();
		Assert.assertEquals("Developer header", visualConcepts, actualHeader);
	}
	
	@org.junit.Test
	@FileParameters(value = "src/main/resources/data/games.csv", mapper = CsvWithHeaderMapper.class)
	public void testGames(String id, String name, String release, String imageUrl) {
		LOG.info("id: {} name: {} release: {} url: {}", id, name, release, imageUrl);
	}
	
}
