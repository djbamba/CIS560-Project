package com.dj.controller;

import com.dj.model.Game;
import com.dj.model.System;
import com.dj.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */
@Controller
@RequestMapping("system/")
public class SystemController {

    @Autowired
    private SystemRepository systemRepository;

    @RequestMapping(value = "{system}", method = RequestMethod.GET)
    public String getSystemByName(@PathVariable(value = "system") String title, Model model) {
        String name = title.replace("_", " ");
        System test = systemRepository.findByName(name);

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

        model.addAttribute("system", test);

        return "systems/system";
    }
}
