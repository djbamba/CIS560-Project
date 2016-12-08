package com.dj.utils.pages;

import org.openqa.selenium.By;

/**
 * Created String DJ on 11/28/16.
 */
public interface PageConstants {
	
	String GOOGLE_URL = "http://www.google.com";
	String WIKI_URL = "https://en.wikipedia.org/wiki/Main_Page";
	String INFO_BOX = ".//table[@class='infobox hproduct']";
	String DEV_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Developer(s)')]";
	String DEV_2 = "";
	String PUB_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Publisher(s)')]";
	String PUB_2 = "";
	String DES_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Designer(s)')]";
	String DES_2 = "";
	String PLAT_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Platform(s)')]";
	String PLAT_2 = "";
	String GEN_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Genre(s)')]";
	String GEN_2 = "";
	String IMAGE_PATH = ".//table[@class='infobox hproduct']//tr/td/a/img";
}
