package com.dj.utils.pages;

import com.dj.model.Developer;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.System;
import com.thoughtworks.selenium.condition.Text;

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
import java.util.stream.Collectors;

/**
 * Created by DJ on 11/28/16.
 */
public class WikiResultsPage extends WikiPage {
	
	private static final Logger LOG = LogManager.getLogger(WikiResultsPage.class);

//	".//table[@class='infobox hproduct']/tbody//th[contains(.,'linkText')]"
	
	@FindBy(xpath = "//table[@class='infobox hproduct']")
	private WebElement infoBlock;
	
	@FindBy(xpath = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Developer(s)')]")
	private WebElement developer;
	
	//	/td/*[not(self::a[contains(.,'‹See Tfd›')])][1]
	@FindBy(xpath = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Publisher(s)')]")
	private WebElement publisher;
	
	//	/td//text()[not(contains(.,'('))]
	@FindBy(xpath = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Designer(s)')]")
	private WebElement designer;
	
	//	//span[@class='nowraplinks']/*[not(self::small)]
	@FindBy(xpath = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Platform(s)')]")
	private WebElement platforms;
	
	//	//table[@class='infobox hproduct']//tr[contains(.,'Genre(s)')]/td/a
	@FindBy(xpath = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Genre(s)')]")
	private WebElement genres;
	
	@FindBy(xpath = "//table[@class='infobox hproduct']//tr[2]/td/a/img")
	private WebElement image;
	
	// TODO: 11/28/16 add field and method for scores
	@FindBy(xpath = "")
	private List<WebElement> scores;
	
	private WebElement temp;
	
	private List<WebElement> temps;
	
	public WikiResultsPage(WebDriver driver) {
		super(driver, null);
	}
	
	public String shredBlock() {
		return infoBlock.getText();
	}
	
	public Developer getDeveloper() {
		By xp1 = By.xpath(".//table[@class='infobox hproduct']/tbody//th[contains(.,'Developer(s)')]/following-sibling::td/*[1]");
		By xp2 = By.xpath(".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Developers')]/following-sibling::td/*[1]");
		
		if (elementExists(developer)) {
			temp = driver.findElement(xp1);
			return new Developer(temp.getText(), getDesigner());
		} else if (elementExists(xp2)) {
			temp = driver.findElement(xp2);
			return new Developer(temp.getText(), getDesigner());
		} else {
			return new Developer("N/A", getDesigner());
		}
	}
	
	public Publisher getPublisher() {
		By xp1 = By.xpath(".//table[@class='infobox hproduct']/tbody//th[contains(.,'Publisher(s)')]/following-sibling::td/*[1]");
		By xp2 = By.xpath(".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Publishers')]/following-sibling::td/*[1]");
		
		if (elementExists(publisher)) {
			temp = driver.findElement(xp1);
			return new Publisher(temp.getText(), "M");
		} else if (elementExists(xp2)) {
			temp = driver.findElement(xp2);
			return new Publisher(temp.getText(), "M");
		} else {
			return null;
		}
	}
	
	public String getDesigner() {
		By xp1 = By.xpath(".//table[@class='infobox hproduct']/tbody//th[contains(.,'Designer(s)')]/following-sibling::td//text()[1]");
		By xp2 = By.xpath(".//table[@class='infobox hproduct']/tbody//th[contains(.,'Designer(s)')]/following-sibling::td//a[1]");
		
		if (elementExists(designer)) {
			// TODO: 12/6/16 handle object text or webelement 
			if (driver.findElement(xp1) instanceof Text);
		}
		if (elementExists(xp2)) {
			return driver.findElement(xp2).toString();
		} else {
			return "N/A";
		}
	}
	
	public List<System> getPlatforms() {
		By xp1 = By.xpath(".//table[@class='infobox hproduct']/tbody//th[contains(.,'Platform(s)')]/following-sibling::td//a");
		By xp2 = By.xpath(".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Platforms')]/following-sibling::td//a");
		List<System> systems;
		
		if (elementExists(platforms)) {
			temps = driver.findElements(xp1);
			
			systems = temps.stream()
			               .filter(element -> (!element.getText().equals("") && !element.getText().equals(" ")))
			               .map(element -> new System(element.getText()))
			               .collect(Collectors.toList());
			
			systems.stream().forEach(system -> LOG.info(system.toString()));
			
			return systems;
		}
		if (elementExists(xp2)) {
			temps = driver.findElements(xp2);
			
			systems = temps.stream()
			               .filter(element -> (!element.getText().equals("") && !element.getText().equals(" ")))
			               .map(element -> new System(element.getText()))
			               .collect(Collectors.toList());
			systems.stream().forEach(system -> LOG.info(system.toString()));
			
			return systems;
		}
		
		return null;
	}
	
	// TODO: 12/6/16 Finish Genres
	public List<Genre> getGenres() {
		By xp1 = By.xpath(".//table[@class='infobox hproduct']/tbody//th[contains(.,'Platform(s)')]/following-sibling::td//a");
		By xp2 = By.xpath(".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Genres')]/following-sibling::td/a");
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
	
	static boolean elementExists(WebElement element) {
		try {
			element.getText();
			return true;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return false;
		}
	}
	
	static boolean elementExists(By findBy) {
		try {
			driver.findElement(findBy);
			return true;
		} catch (NoSuchElementException e) {
//			e.printStackTrace();
			return false;
		}
	}
	
	// TODO: 12/5/16 Sit in the corner and cry.
	
}
