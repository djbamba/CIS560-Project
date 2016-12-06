package com.dj.utils.pages;

import com.dj.model.Developer;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.System;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 11/28/16.
 */
public class WikiResultsPage extends WikiPage {
	
	private static final Logger LOG = LogManager.getLogger(WikiResultsPage.class);
	
	private StringBuilder sb = new StringBuilder();
	
	@FindBy(xpath = "//table[@class='infobox hproduct']")
	private WebElement infoBlock;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[3]/td/a[1]")
	private WebElement developer;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[contains(.,'Publisher(s)')]/td/*[not(self::a[contains(.,'‹See Tfd›')])][1]")
	private WebElement publisher;
	
	@FindBy(xpath = "//div[@id='mw-content-text']/table/tbody/x:tr[contains(.,'Designer(s)')]/td//text()[not(contains(.,'('))]")
	private WebElement designer;
	
	@FindBy(xpath = "//span[@class='nowraplinks']/*[not(self::small)]")
	private WebElement platforms;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[contains(.,'Genre(s)')]/td/a")
	private WebElement genres;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[2]/td/a/img")
	private WebElement image;
	
	// TODO: 11/28/16 add field and method for scores
	@FindBy(xpath = "")
	private List<WebElement> scores;
	
	private WebElement stubbornElement;
	
	private List<WebElement> stubbornElements;
	
	public WikiResultsPage(WebDriver driver) {
		
		super(driver, null);
	}
	

	public String shredBlock() {
		
		return infoBlock.getText();
	}
	
	public Publisher getPublisher() {
		/*
		try {
			
			return new Publisher(publisher.get(0).getText(), "M");
			
		} catch (IndexOutOfBoundsException e3) {
			try {
				
				stubbornElement = driver.findElement(By.xpath("//table[@class='infobox hproduct']//tr[contains(.,'Publisher(s)')]/td"));
				return new Publisher(stubbornElement.getText(), "M");
				
			} catch (NoSuchElementException e2) {
				
				stubbornElement = driver.findElement(By.xpath("//table[@class='infobox infobox vevent']//tr[contains(.,'Publishers')]/td"));
				return new Publisher(stubbornElement.getText(), "M");
				
			}
		}
		*/
		return null;
	}
	
	public Developer getDeveloper() {
		/*
		String designerS;
		if (designer.isEmpty())
			designerS = "N/A";
		else designerS = designer.get(0).getText();

		try {
			return new Developer(developer.get(0).getText(), designerS);

		} catch (NoSuchElementException e1) {

			try {
				stubbornElements = driver.findElements(By.xpath("//table[@class='infobox hproduct']//tr[3]/td"));
				return new Developer(stubbornElement.getText(), designerS);

			} catch (NoSuchElementException e2) {

				stubbornElements = driver.findElements(By.xpath("//table[@class='infobox infobox vevent']//tr[contains(.,'Developers')]/td"));
				return new Developer(stubbornElement.getText(), designerS);
			}
		}
		*/
		
		return null;
	}
	
	public List<System> getPlatforms() {
		
		/*
			List<System> systems = new ArrayList<>();
		
		try {
			platforms.forEach(platform -> {

				if (!platform.getText().equals("") && !platform.getText().equals(" "))
					systems.add(new System(platform.getText()));
			});
		} catch (NoSuchElementException e) {
			stubbornElements = driver.findElements(By.xpath("//table[@class='infobox infobox vevent']//tr[contains(.,'Developers')]/td"));

		}
		
		return systems;
		*/
		return null;
	}
	
	public List<Genre> getGenres() {
		
		/*
		List<Genre> genreList = new ArrayList<>();
		
		genres.forEach(genre -> {
			if (!genre.getText().equals("") && !genre.getText().equals(" "))
				genreList.add(new Genre(genre.getText()));
		});
		
		return genreList;
		*/
		return null;
	}
	
	public String getImageSource() {
		
		String src = "";
		try {
			src = URLDecoder.decode(image.getAttribute("srcset").substring(2, image.getAttribute("srcset").lastIndexOf("g") + 1), "UTF-8");
		} catch (StringIndexOutOfBoundsException e) {
			src = image.getAttribute("src").substring(2);
		} catch (UnsupportedEncodingException e) {
			LOG.error("Unsupported Encoding Exception in WikiResultsPage getImageSource", e);
		} catch (NoSuchElementException e) {
			return "N/A";
		} catch (WebDriverException e) {
			return "N/A";
		}
		return "https://" + src;
	}
	
	// TODO: 12/5/16 Sit in the corner and cry.
	
}
