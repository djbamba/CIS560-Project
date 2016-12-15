package com.dj.controller;

import com.dj.model.Game;
import com.dj.model.Genre;
import com.dj.model.System;
import com.dj.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */
@Controller
@RequestMapping("genre/")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping(value = "{genre}", method = RequestMethod.GET)
    public String findByGenre(@PathVariable(value = "genre") String title, Model model) {
        String name = title.replace("_", " ");
        Genre test = genreRepository.findByGenre(name.toUpperCase());

        List<Game> gameList = new ArrayList<>();
        for (Game game : test.getGames()) {
            if (!gameList.contains(game)) {
                gameList.add(game);
            }
        }
        test.setGames(gameList);

        for (Game game : test.getGames()) {
            List<System> systemList = new ArrayList<>();
            for (System system : game.getSystems()) {
                if (!systemList.contains(system)) {
                    systemList.add(system);
                }
            }
            game.setSystems(systemList);
        }

        model.addAttribute("genre",test);

        return "genres/genre";
    }


}
