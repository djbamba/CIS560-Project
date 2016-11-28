package com.dj.utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by DJ on 11/28/16.
 */
public class WikiResultsPage extends PageObject {
	
	@FindBy(css = "table.infobox.hproduct")
	private WebElement infoBlock;
	
	public WikiResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public String shredBlock() {
		return infoBlock.getText();
	}
	
}
