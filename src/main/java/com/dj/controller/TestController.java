package com.dj.controller;

import com.dj.model.Game;
import com.dj.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by DJ on 11/10/16.
 */
@Controller
public class TestController {
	
	private static final Logger LOG = LogManager.getLogger(TestController.class);
	private static Path testDataPath = Paths.get("src/main/resources/data/test/").toAbsolutePath();
	private String gamePath = testDataPath.toString().concat("/game1.json");
	private File gameFile = new File(gamePath);
	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping(value = "/test", produces = "application/json")
	public @ResponseBody String getGame() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Game game = mapper.readValue(gameFile, Game.class);
		
		gameRepository.save(game);
		
		LOG.info("testDataPath: {}\n gamePath: {}\n game: {}",
		         testDataPath, gamePath, game);
		
		return mapper.writeValueAsString(game);
	}
}
