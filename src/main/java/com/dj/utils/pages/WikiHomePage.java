package com.dj.utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dj.utils.pages.PageConstants.*;

/**
 * Created by DJ on 11/28/16.
 */

public class WikiHomePage extends PageObject {
	
	@FindBy(id = "searchInput")
	private WebElement searchBar;
	
	public WikiHomePage(WebDriver driver) {
		super(driver, WIKI_URL);
	}
	
	public void searchGame(String search){
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(search);
	}
	
	public WikiResultsPage getWikiResultsPage() {
		searchBar.submit();
		return new WikiResultsPage(this.driver);
	}
	
}
