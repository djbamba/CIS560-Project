package com.dj.utils.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by DJ on 11/28/16.
 */
public class GoogleResultsPage extends GooglePage {
	
	private static final Logger LOG = LogManager.getLogger(GoogleResultsPage.class);
	
	@FindBy(id = "rhs")
	private WebElement infoBlock;
	
	public GoogleResultsPage(WebDriver driver) {
		super(driver,null);
	}
	
	public String shredBlock() {
		LOG.info(infoBlock.getText());
		return infoBlock.getText();
	}
	
}
