package com.dj.controller;

import com.dj.model.Game;
import com.dj.model.Genre;
import com.dj.model.System;
import com.dj.repository.GameRepository;
import com.dj.repository.GenreRepository;
import com.dj.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.jpa.internal.EntityManagerImpl.LOG;

/**
 * Created by zterwort on 12/13/16.
 */
@Controller
@RequestMapping("search/")
public class SearchController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private SystemRepository systemRepository;

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping(value = "{searchTerm}", method = RequestMethod.GET)
    public String find(@PathVariable(value = "searchTerm") String title, Model model) {
        String name = title.replace("_", " ");
        List<Game> games = gameRepository.findByNameContaining(name);
        model.addAttribute("games", games);


        List<Genre> genres = genreRepository.findByGenreContaining(name.toUpperCase());

        for (Genre genre : genres){
            List<Game> genreGames = new ArrayList<>();
            for (Game game : genre.getGames()){
                if(!genreGames.contains(game)){
                    genreGames.add(game);
                }
            }
            genre.setGames(genreGames);
        }
        model.addAttribute("genres", genres);
        LOG.info(genres);

        List<System> systems = systemRepository.findByNameContaining(name);

        for (System system : systems){
            List<Game> systemGames = new ArrayList<>();
            for(Game game : system.getGames()){
                if(!systemGames.contains(game)){
                    systemGames.add(game);
                }
            }
            system.setGames(systemGames);
        }
        model.addAttribute("systems", systems);

        return "pages/searched";
    }


}
