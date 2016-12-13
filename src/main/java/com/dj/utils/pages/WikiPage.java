package com.dj.utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

import static com.dj.utils.pages.PageConstants.*;

/**
 * Created by DJ on 11/28/16.
 */

public class WikiPage extends PageObject {
	
	@FindBy(id = "searchInput")
	
	protected WebElement searchBar;

	@FindBy(id = "//table[@id='noarticletext']")
	protected WebElement missingInfo;

	public WikiPage(WebDriver driver) {
		super(driver, WIKI_URL);
	}
	
	public WikiPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public WikiPage searchGame(String search) {
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(search);
		
		return this;
	}
	
	public WikiResultsPage getWikiResultsPage() {
		searchBar.submit();
		return new WikiResultsPage(this.driver);
	}

	protected String processCitation(String id) {
		WebElement citation = driver.findElement(By.id(id.substring(id.indexOf('#') + 1)));
		return citation.findElement(By.xpath(".//cite[1]/a[1]")).getAttribute("href");
	}

	public boolean containsMissingInfo() {

        return elementExists(missingInfo);
    }
}
