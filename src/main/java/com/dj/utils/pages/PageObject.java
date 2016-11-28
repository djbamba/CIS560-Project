package com.dj.utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by DJ on 11/28/16.
 */
public class PageObject {
	
	protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		this(driver,null);
	}
	
	public void config() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public PageObject(WebDriver driver, String url) {
		this.driver = driver;
		
		config();
		
		if(url != "" && url != null)
			driver.get(url);
		
		this.load();
	}
	
	public void load() {
		PageFactory.initElements(this.driver,this);
	}
	
	public void close() {
		driver.quit();
	}
	
	
}
