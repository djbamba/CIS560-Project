package com.dj.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import junitparams.JUnitParamsRunner;

/**
 * Created by DJ on 11/9/16.
 */
// TODO: 12/15/16 Make this a real test class
@RunWith(JUnitParamsRunner.class)
public class Test {
	private static final Logger LOG = LogManager.getLogger(Test.class);
	private WebDriver driver;
	
	private String baseUrl = "localhost:8080/";
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox-2.app/Contents/MacOS/firefox-bin");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
