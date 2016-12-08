package com.dj.utils.pages;

import com.dj.model.Developer;
import com.dj.model.Genre;
import com.dj.model.Publisher;
import com.dj.model.System;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.dj.utils.pages.PageConstants.*;

/**
 * Created by DJ on 11/28/16.
 */
public class WikiResultsPage extends WikiPage {
	
	private static final Logger LOG = LogManager.getLogger(WikiResultsPage.class);

	@FindBy(xpath = INFO_BOX)
	private WebElement infoBox;
	
	@FindBy(xpath = DEV_1)
	private WebElement developer;
	
	@FindBy(xpath = PUB_1)
	private WebElement publisher;
	
	@FindBy(xpath = DES_1)
	private WebElement designer;
	
	@FindBy(xpath = PLAT_1)
	private WebElement platforms;
	
	@FindBy(xpath = GEN_1)
	private WebElement genres;
	
	@FindBy(xpath = IMAGE_PATH)
	private WebElement image;
	
	// TODO: 11/28/16 add field and method for scores
	@FindBy(xpath = "")
	private List<WebElement> scores;
	
	private WebElement tempE;
	
	private List<WebElement> tempsE;
	
	public WikiResultsPage(WebDriver driver) {
		super(driver, null);
	}
	
	public String shredBlock() {
		return infoBox.getText();
	}
	
	public Developer getDeveloper() {
		By xp1 = By.xpath("(" + DEV_1 + "/following-sibling::td//a)[1]");
		By xp2 = By.xpath(DEV_1 + "/following-sibling::td");
		By xp3 = By.xpath("(" + DEV_2 + "/following-sibling::td//a)[1]");
		
		if (elementExists(developer)) {
			tempE = driver.findElement(getPresentElement(xp1, xp2));
			return new Developer(tempE.getText(), getDesigner());
		} else if (elementExists(DEV_2)) {
			tempE = driver.findElement(xp3);
			return new Developer(tempE.getText(), getDesigner());
		} else {
			return new Developer("N/A", getDesigner());
		}
	}
	
	public Publisher getPublisher() {
		By xp1 = By.xpath("(" + PUB_1 + "/following-sibling::td//a)[1]");
		By xp2 = By.xpath(PUB_1 + "/following-sibling::td");
		By xp3 = By.xpath("(" + PUB_2 + "/following-sibling::td//a)[1]");
		By xp4 = By.xpath(PUB_2 + "/following-sibling::td");
		
		if (elementExists(publisher)) {
			tempE = driver.findElement(getPresentElement(xp1, xp2));
			return new Publisher(tempE.getText(), "M");
		} else if (elementExists(PUB_2)) {
			tempE = driver.findElement(getPresentElement(xp3, xp4));
			return new Publisher(tempE.getText(), "M");
		} else {
			return new Publisher("N/A", "N/A");
		}
		
	}
	
	public String getDesigner() {
		By xp1 = By.xpath("(" + DES_1 + "/following-sibling::td/text()[1][not(self::small)])");
		By xp2 = By.xpath(DES_1 + "/following-sibling::td");
		By xp3 = By.xpath("(" + DES_2 + "/following-sibling::td//text()[1][not(self::small)])");
		By xp4 = By.xpath(DES_2 + "/following-sibling::td");
		
		if (elementExists(designer)) {
			return extractText(getPresentElement(xp1, xp2));
		} else if (elementExists(DES_2)) {
			return extractText(getPresentElement(xp3, xp4));
		}
		return "N/A";
	}
	
	public List<System> getPlatforms() {
		By xp1 = By.xpath(PLAT_1 + "/following-sibling::td//span/a");
		By xp2 = By.xpath(PLAT_2 + "/following-sibling::td//span/a");
		List<System> systems = new ArrayList<>();
		
		if (elementExists(platforms)) {
			tempsE = driver.findElements(xp1);
			
			systems = tempsE.stream()
			                .filter(element -> (!element.getText().equals("") && !element.getText().equals(" ")))
			                .map(element -> new System(element.getText()))
			                .collect(Collectors.toList());
			return systems;
		} else if (elementExists(PLAT_2)) {
			tempsE = driver.findElements(xp2);
			
			systems = tempsE.stream()
			                .filter(element -> (!element.getText().equals("") && !element.getText().equals(" ")))
			                .map(element -> new System(element.getText()))
			                .collect(Collectors.toList());
			return systems;
		}
		return systems;
	}
	
	public List<Genre> getGenres() {
		By xp1 = By.xpath(GEN_1 + "/following-sibling::td//a[not(self::small)]");
		By xp2 = By.xpath(GEN_2 + "/following-sibling::td//a[not(self::small)]");
		
		List<Genre> genreList = new ArrayList<>();
		
		if (elementExists(genres)) {
			
			tempsE = driver.findElements(xp1);
			genreList = tempsE.stream()
			                  .map(genre -> new Genre(genre.getText().toUpperCase()))
			                  .collect(Collectors.toList());
		} else if (elementExists(GEN_2)) {
			
			tempsE = driver.findElements(xp2);
			genreList = tempsE.stream()
			                  .map(genre -> new Genre(genre.getText().toUpperCase()))
			                  .collect(Collectors.toList());
		}
		return genreList;
	}
	
	public String getImageSource() {
		String src = "";
		try {
			src = URLDecoder.decode(image.getAttribute("srcset").substring(2, image.getAttribute("srcset").lastIndexOf("g") + 1), "UTF-8");
		} catch (StringIndexOutOfBoundsException e) {
			src = image.getAttribute("src");
		} catch (UnsupportedEncodingException e) {
			LOG.error("Unsupported Encoding Exception in WikiResultsPage getImageSource", e);
		} catch (NoSuchElementException e) {
			return "N/A";
		} catch (WebDriverException e) {
			return "N/A";
		}
		return "https://" + src;
	}
	
	/**
	 * Method to return whichever By exists. Intended for decreasing code duplication
	 * when checking if each xpath by elementExists.
	 */
	static By getPresentElement(By first, By second) {
		if (elementExists(first))
			return first;
		return second;
	}
	
	static String extractText(By iffyElement) {
		try {
			List<String> allText =
			 Arrays.asList(
			  driver.findElement(iffyElement)
			        .getText()
			        .split("[\n()]", 2)
			 );
			if (allText.size() >= 1)
				return allText.get(0);
			else
				return "N/A";
		} catch (InvalidSelectorException e) {
			return "N/A";
		}
	}
	
}
