package com.dj.utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by DJ on 11/28/16.
 */
public class PageObject {
	
	static protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		this(driver,null);
	}
	
	public void config() {
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	
	/**
	 * Method to return whichever By exists. Intended for decreasing code duplication
	 * when checking if each xpath By elementExists.
	 */
	static By getPresentElement(By first, By second) {
		if (elementExists(first))
			return first;
		return second;
	}
}
