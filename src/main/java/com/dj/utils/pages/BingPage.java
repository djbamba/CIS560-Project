package com.dj.utils.pages;

import com.dj.model.Game;
import com.dj.model.PurchaseWebsite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.dj.utils.pages.PageConstants.PURCHASE_SITES;

/**
 * Created by DJ on 12/12/16.
 */
public class BingPage extends PageObject {
	
	private static final Logger LOG = LogManager.getLogger(BingPage.class);
	
	@FindBy(xpath = PURCHASE_SITES)
	List<WebElement> gameSites;
	
	@FindBy(id = "sb_form_q")
	WebElement searchBar;
	
	public BingPage(WebDriver driver) {
		super(driver, "https://www.bing.com/");
	}
	
	public BingPage searchGame(Game game) {
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(game.getName());
		searchBar.submit();
		return this;
	}
	
	public List<PurchaseWebsite> getPurchaseWebsites() {
		List<PurchaseWebsite> sites = new ArrayList<>();
		String siteName, url, price;
		if(!elementExists(PURCHASE_SITES))
			return null;
		
		for (WebElement el : gameSites) {
			try {
				siteName = el.findElement(By.xpath(".//cite")).getText();
				url = el.findElement(By.xpath(".//div[1]/a[1]")).getAttribute("href");
				price = el.findElement(By.xpath(".//div[1]/p/strong")).getText();
				
				sites.add(new PurchaseWebsite(siteName, url, price));
			} catch (NoSuchElementException e) {
				LOG.error(e);
				continue;
			}
		}
		return sites;
	}
	
}
