package com.dj.controllers;

import com.dj.objects.Game;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by DJ on 11/10/16.
 */
@Controller
public class Test {
	
	private static final Logger LOG = LogManager.getLogger(Test.class);
	
	private static Path testDataPath = Paths.get("src/main/resources/data/test/").toAbsolutePath();
	
	//    private static Path fullPath = Paths.get("").toAbsolutePath();//stops at project directory GameWebScraper
	private String gamePath = testDataPath.toString().concat("/game1.json");
	
	private File gameFile = new File(gamePath);
	
	
	@RequestMapping(value = "/test", produces = "application/json")
	public
	@ResponseBody
	String getGame() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Game game = mapper.readValue(gameFile, Game.class);
		
		LOG.info("fullPath: {}\n testDataPath: {}\n gamePath:{}\n game:{}",
		         testDataPath, gamePath, game);
		
		return mapper.writeValueAsString(game);
	}
}
