package com.dj.utils.pages;

/**
 * Created String DJ on 11/28/16.
 */
public interface PageConstants {
	
	String GOOGLE_URL = "http://www.google.com";
	String WIKI_URL = "https://en.wikipedia.org/wiki/Main_Page";
	
	String INFO_BOX = ".//table[@class='infobox hproduct']";
	
	String DEV_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Developer(s)')]";
	String DEV_2 = ".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Developers')]";
	
	String PUB_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Publisher(s)')]";
	String PUB_2 = ".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Publishers')]";
	
	String DES_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Designer(s)')]";
	String DES_2 = ".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Designers')]";
	
	String PLAT_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Platform(s)')]";
	String PLAT_2 = ".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Platforms')]";
	
	String GEN_1 = ".//table[@class='infobox hproduct']/tbody//th[contains(.,'Genre(s)')]";
	String GEN_2 = ".//table[@class='infobox infobox vevent']/tbody//th[contains(.,'Genres')]";
	
	String IMAGE_PATH = ".//table[@class='infobox hproduct']//tr/td/a/img";

	String WIKI_COMPANY_PUBLISHER = "https://en.wikipedia.org/wiki/List_of_video_game_publishers";
	
}
