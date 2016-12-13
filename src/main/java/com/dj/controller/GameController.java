package com.dj.controller;

import com.dj.model.*;
import com.dj.repository.GameRepository;

import com.dj.repository.PurchaseWebsiteRepository;
import com.dj.repository.ScoreRepository;
import com.dj.repository.ScoreWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.jpa.internal.EntityManagerImpl.LOG;

/**
 * Created by DJ on 11/23/16.
 */
@Controller
@RequestMapping("game/")
public class GameController {
	
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PurchaseWebsiteRepository purchaseRepository;

	private ScoreRepository scoreRepository;

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
		model.addAttribute("game",test);
		model.addAttribute("comment", new Comment());
		List<PurchaseWebsite> purchase = test.getPurchaseWebsites();
		List<PurchaseWebsite> purchaseWebsites = new ArrayList<>();
		for (PurchaseWebsite purchaseWebsite : purchase) {
			if(!purchaseWebsites.contains(purchaseWebsite)){
				purchaseWebsites.add(purchaseWebsite);
			}
		}
		model.addAttribute("purchase", purchaseWebsites);
		List<ScoreWebsite> scoreWebsites = test.getScoreWebsites();
		List<ScoreWebsite> scoreWebsites2 = new ArrayList<>();
		for (ScoreWebsite scoreWebsite : scoreWebsites) {
			if(!scoreWebsite.getScore().getScore().trim().equals("")){
				scoreWebsites2.add(scoreWebsite);
			}
		}
		model.addAttribute("score", scoreWebsites2);
		
		return "games/game";
	}

	@RequestMapping(value = "recent", method = RequestMethod.GET)
	public String getRecentGames(@RequestParam("searchText")String searchText, Model model){
		model.addAttribute("games", gameRepository.findByNameLike(searchText));
		return "games/game";


	}
	@RequestMapping(value = "/addComment/{gameId}", method = RequestMethod.POST)
	public String addComment(@Valid @ModelAttribute("comment") Comment comment,
							 @PathVariable(value = "gameId") String gameId, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) LOG.error(bindingResult);

		Game game = gameRepository.findById(Integer.parseInt(gameId));
		String redirect = "redirect:/game/" + game.getName().replace(" ", "_");
		comment.setDate(new Date());
		game.getComments().add(comment);

		gameRepository.save(game);

		return redirect;

	}
}
