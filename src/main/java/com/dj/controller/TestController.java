package com.dj.controller;

import com.dj.model.Game;
import com.dj.repository.GameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by DJ on 11/10/16.
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = LogManager.getLogger(TestController.class);
	private static Path testDataPath = Paths.get("src/main/resources/data/test/").toAbsolutePath();
	private String gamePath = testDataPath.toString().concat("/game1.json");
	private File gameFile = new File(gamePath);
	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping(value = "/games", produces = "application/json")
	public @ResponseBody String getGame() throws IOException {
		List<Game> games = gameRepository.findAll();
		StringBuilder sb = new StringBuilder();
		//allows us to convert our objects to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		games.forEach(game -> {
			
			try {
				sb.append(mapper.writeValueAsString(game)+"\n");
			} catch (JsonProcessingException e) {
				LOG.error("test controller error: ", e);
			}
		});
		
		return sb.toString();
	}
	
	@RequestMapping(value = "/searched", produces = "text/html")
	public String getSearched() {
		return "pages/searched";
	}
}
