package com.dj.test;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


/**
 * Created by DJ on 11/9/16.
 */


public class TestJson {
	private static final Logger LOG = LogManager.getLogger(TestJson.class);
	
	private static String baseUrl = "http://www.metacritic.com/";
	private static String urlSlug = "browse/games/score/metascore/all/all/filtered?sort=desc&page=0";
	private static int pageCount = 0;
	
	@Test
	public static void getPage() {
		
		Response response =
				given().param("sort", "desc", "page", 0)
				       .baseUri(baseUrl)
				       .when()
				       .get("browse/games/score/metascore/all/all/filtered")
				       .andReturn();
		
		LOG.info(response.body().prettyPrint());
	}
	
	@Test
	public void testIndex() {
		System.out.println("TestJson class");
	}
}
