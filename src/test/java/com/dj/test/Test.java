package com.dj.test;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


/**
 * Created by DJ on 11/9/16.
 */


public class Test {
	private static final Logger LOG = LogManager.getLogger(Test.class);
	
	@org.testng.annotations.Test
	public static void testExtraction() {
		
		LOG.info("frog");
	}
	
}
