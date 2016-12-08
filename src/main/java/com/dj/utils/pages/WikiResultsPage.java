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
import java.util.List;
import java.util.stream.Collectors;

import static com.dj.utils.pages.PageConstants.*;

/**
 * Created by DJ on 11/28/16.
 */
public class WikiResultsPage extends WikiPage {
	
	private static final Logger LOG = LogManager.getLogger(WikiResultsPage.class);

//	".//table[@class='infobox hproduct']/tbody//th[contains(.,'linkText')]"
	
	@FindBy(xpath = INFO_BOX)
	private WebElement infoBox;
	
	@FindBy(xpath = DEV_1)
	private WebElement developer;
	
	//	/td/*[not(self::a[contains(.,'‹See Tfd›')])][1]
	@FindBy(xpath = PUB_1)
	private WebElement publisher;
	
	//	/td//text()[not(contains(.,'('))]
	@FindBy(xpath = DES_1)
	private WebElement designer;
	
	//	//span[@class='nowraplinks']/*[not(self::small)]
	@FindBy(xpath = PLAT_1)
	private WebElement platforms;
	
	//	//table[@class='infobox hproduct']//tr[contains(.,'Genre(s)')]/td/a
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
		// TODO: 12/7/16 handle multiple developers
		By xp1 = By.xpath(DEV_1 + "/following-sibling::td/*[1]");
		By xp2 = By.xpath(DEV_1 + "/following-sibling::td");
		By xp3 = By.xpath(DEV_2 + "/following-sibling::td/*[1]");
		
		if (elementExists(DEV_1)) {
			tempE = driver.findElement(getPresentElement(xp1, xp2));
			return new Developer(tempE.getText(), "Test" /* getDesigner()*/);
		} else if (elementExists(DEV_2)) {
			tempE = driver.findElement(xp3);
			return new Developer(tempE.getText(), "Test" /*getDesigner()*/);
		} else {
			return new Developer("N/A", "Test" /*getDesigner()*/);
		}
	}
	
	public Publisher getPublisher() {
		// TODO: 12/7/16 handle multiple publishers
		By xp1 = By.xpath(PUB_1 + "/following-sibling::td/*[1]");
		By xp2 = By.xpath(PUB_1 + "/following-sibling::td");
		By xp3 = By.xpath(PUB_2 + "/following-sibling::td/*[1]");
		By xp4 = By.xpath(PUB_2 + "/following-sibling::td");
		
		if (elementExists(PUB_1)) {
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
//		.//table[@class='infobox hproduct']/tbody//th[contains(.,'Designer(s)')]/following-sibling::td/text()[1]
		// TODO: 12/7/16 handle multiple designers and ignore things in parens
		
		By xp1 = By.xpath("(" + DES_1 + "/following-sibling::td//text()[not(contains(.,'(' or ')'))][1])[1]");
		By xp2 = By.xpath(DES_1 + "/following-sibling::td");
		By xp3 = By.xpath("(" + DES_2 + "/following-sibling::td//text()[not(contains(.,'(' or ')'))][1])[1]");
		By xp4 = By.xpath(DES_2 + "/following-sibling::td");
		
		if (elementExists(DES_1)) {
			return extractText(getPresentElement(xp1, xp2));
		} else if (elementExists(DES_2)) {
			return extractText(getPresentElement(xp3, xp4));
		}
		return "N/A";
	}
	
	public List<System> getPlatforms() {
		By xp1 = By.xpath(PLAT_1 + "/following-sibling::td//a");
		By xp2 = By.xpath(PLAT_2 + "/following-sibling::td//a");
		List<System> systems = new ArrayList<>();
		
		if (elementExists(PLAT_1)) {
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
	
	// TODO: 12/6/16 Finish Genres
	public List<Genre> getGenres() {
		By xp1 = By.xpath(GEN_1 + "/following-sibling::td//a");
		By xp2 = By.xpath(GEN_2 + "/following-sibling::td//a");
		
		List<Genre> genreList = new ArrayList<>();
		
		if (elementExists(GEN_1)) {
			
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
			return driver.findElement(iffyElement).getText();
		} catch (InvalidSelectorException e) {
			return driver.findElement(iffyElement).toString();
		}
	}
	
	static boolean elementExists(WebElement element) {
		try {
			element.getText();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	static boolean elementExists(By findBy) {
		try {
			driver.findElement(findBy);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	static boolean elementExists(String find) {
		try {
			driver.findElement(By.xpath(find)).getText();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
