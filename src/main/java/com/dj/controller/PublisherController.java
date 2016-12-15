package com.dj.controller;

import com.dj.model.Game;
import com.dj.model.Publisher;
import com.dj.model.System;
import com.dj.repository.PublisherRepository;
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
@RequestMapping("publisher/")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping(value = "{publisher}", method = RequestMethod.GET)
    public String findByName(@PathVariable(value = "publisher") String title, Model model) {
        String name = title.replace("_", " ");
        List<Publisher> test = publisherRepository.findByNameContaining(name);

        for (Publisher publisher : test) {
            for (Game game : publisher.getGames()) {
                List<System> systemList = new ArrayList<>();
                for (System system : game.getSystems()){
                    if (!systemList.contains(system)) {
                        systemList.add(system);
                    }
                }
                game.setSystems(systemList);
            }
        }

        model.addAttribute("publisher", test.get(0));

        return "publishers/publisher";
    }
}
