package com.dj.utils.pages;

import com.dj.model.Game;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dj.utils.pages.PageConstants.*;

/**
 * Created by DJ on 11/28/16.
 */
public class GooglePage extends PageObject {
	
	@FindBy(id = "lst-ib")
	protected WebElement searchBar;
	
	public GooglePage(WebDriver driver) {
		super(driver, GOOGLE_URL);
	}
	
	public GooglePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public GooglePage searchGame(String search) {
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(search);
		return this;
	}
	
	public GoogleResultsPage getGoogleResultsPage() {
		searchBar.submit();
		return new GoogleResultsPage(this.driver);
	}
	
	public void getpurchaseWebsites(Game game) {
		
	}
}
