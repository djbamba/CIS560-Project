package com.dj.controller;

import com.dj.model.Game;
import com.dj.repository.GameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by DJ on 11/10/16.
 */
@Controller
@RequestMapping("/tests")
public class TestController {
	
	private static final Logger LOG = LogManager.getLogger(TestController.class);

	@Autowired
	private GameRepository gameRepository;


	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void testComment(Model model) {
		String gameName = "Halo 2";
		Game game = gameRepository.findByName(gameName);
		model.addAttribute("game", game);
		LOG.debug("On Test Page");
	}
}
