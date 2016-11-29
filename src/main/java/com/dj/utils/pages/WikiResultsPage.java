package com.dj.utils.pages;

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
	private List<WebElement> publishers;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[7]/td")
	private List<WebElement> designers;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[13]//li")
	private List<WebElement> platforms;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[15]/td//a")
	private List<WebElement> genres;
	
	public WikiResultsPage(WebDriver driver) {
		super(driver, null);
	}
	
	public String shredBlock() {
		LOG.info(infoBlock.getText());
		return infoBlock.getText();
	}
	
	
	
	public List<System> getPlatforms() {
		
		List<System> systems = new ArrayList<>();
		
		platforms.forEach(platforms -> {
			LOG.info("Platform: {}",platforms.getText());
			systems.add(new System(platforms.getText()));
		});
		
		return systems;
	}
}
