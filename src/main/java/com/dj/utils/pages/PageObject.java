package com.dj.utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by DJ on 11/28/16.
 */
public class PageObject {
	
	protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		this(driver,null);
	}
	
	public PageObject(WebDriver driver, String url) {
		this.driver = driver;
		
		if(url != "" && url != null)
			driver.get(url);
		
		this.load();
	}
	
	public void load() {
		PageFactory.initElements(this.driver,this);
	}
	
	
}
