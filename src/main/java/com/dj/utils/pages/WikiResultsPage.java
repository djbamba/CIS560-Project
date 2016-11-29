package com.dj.utils.pages;

import com.dj.model.Developer;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.System;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[3]/td/a")
	private List<WebElement> developers;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[4]/td/a")
	private WebElement publisher;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[6]/td")
	private List<WebElement> designers;
	
	@FindBy(xpath = "//span[@class='nowraplinks']/a")
	//old path //table[@class='infobox hproduct']//tr[13]//li
	private List<WebElement> platforms;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[15]/td//a")
	private List<WebElement> genres;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[2]/td/a/img")
	private WebElement image;
	
	public WikiResultsPage(WebDriver driver) {
		super(driver, null);
	}
	
	/**
	 * Method to test the information block's contents
	 *
	 * @return information block's text contents
	 */
	public String shredBlock() {
		LOG.info(infoBlock.getText());
		return infoBlock.getText();
	}
	
	public Publisher getPublisher() {
		return new Publisher(publisher.getText(), "M");
	}
	
	public List<Developer> getDevelopers() {
		List<Developer> devs = new ArrayList<>();
		
		developers.forEach(dev -> {
			LOG.info("Developer: {} Designer: {}\n", dev.getText(), designers.get(0).getText());
			devs.add(new Developer(dev.getText(), designers.get(0).getText()));
		});
		
		return devs;
	}
	
	public List<System> getPlatforms() {
		
		List<System> systems = new ArrayList<>();
		
		platforms.forEach(platforms -> {
			LOG.info("Platform: {}", platforms.getText());
			systems.add(new System(platforms.getText()));
		});
		
		return systems;
	}
	
	public List<Genre> getGenres() {
		List<Genre> genreList = new ArrayList<>();
		
		genres.forEach(genre -> {
			genreList.add(new Genre(genre.getText()));
		});
		
		return genreList;
	}
	
	public String getImageSource() {
		return image.getAttribute("src").substring(2);
	}
	
}
