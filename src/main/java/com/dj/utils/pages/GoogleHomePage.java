package com.dj.utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dj.utils.pages.PageConstants.*;

/**
 * Created by DJ on 11/28/16.
 */
public class GoogleHomePage extends PageObject {
	
	@FindBy(id = "lst-ib")
	private WebElement searchBar;
	
	public GoogleHomePage(WebDriver driver) {
		super(driver, GOOGLE_URL);
	}
	
	public void searchGame(String search) {
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(search);
	}
	
	public GoogleResultsPage getGoogleResultsPage() {
		searchBar.submit();
		return new GoogleResultsPage(this.driver);
	}
	
}
