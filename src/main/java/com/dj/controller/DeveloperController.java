package com.dj.controller;

import com.dj.model.Developer;
import com.dj.model.Game;
import com.dj.model.Publisher;
import com.dj.model.System;
import com.dj.repository.DeveloperRepository;
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
@RequestMapping("developer/")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @RequestMapping(value = "{developer}", method = RequestMethod.GET)
    public String findByName(@PathVariable(value = "developer") String title, Model model) {
        String name = title.replace("_", " ");
        List<Developer> test = developerRepository.findByNameContaining(name);

        for (Developer developer : test) {
            for (Game game : developer.getGames()) {
                List<System> systemList = new ArrayList<>();
                for (System system : game.getSystems()){
                    if (!systemList.contains(system)) {
                        systemList.add(system);
                    }
                }
                game.setSystems(systemList);
            }
        }

        model.addAttribute("developer", test.get(0));

        return "developers/developer";
    }
}
