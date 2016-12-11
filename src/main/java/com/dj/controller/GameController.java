package com.dj.controller;

import com.dj.model.Game;
import com.dj.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */
@Controller
@RequestMapping("game/")
public class GameController {
	
	@Autowired
	private GameRepository gameRepository;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<Game> getGames() {
		return gameRepository.findAll();
	}
	 
//	@RequestMapping(value = "{gameID}", method = RequestMethod.GET)
//	public Game getGameById(@PathVariable(value = "gameID") String gameID){
//		return gameRepository.findOne(Integer.parseInt(gameID));
//	}
	
	@RequestMapping(value = "{gameTitle}", method = RequestMethod.GET)
	public String getGameByTitle(@PathVariable(value = "gameTitle") String title, Model model) {
		String name = title.replace("_", " ");
		Game test = gameRepository.findByName(name);
		System.out.println(test.toString());
		model.addAttribute("game",test);
		
		return "games/game";
	}
	
//	@RequestMapping(value = "recent", method = RequestMethod.GET)
//	public String getRecentGames(Model model) {
//		model.addAttribute("games", gameRepository.)
//	}
	
}
