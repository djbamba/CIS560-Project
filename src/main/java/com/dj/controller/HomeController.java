package com.dj.controller;

import com.dj.repository.GenreRepository;
import com.dj.repository.SystemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by DJ on 11/9/16.
 */
@Controller
public class HomeController {
    private static final Logger LOG = LogManager.getLogger(HomeController.class);

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private SystemRepository systemRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        LOG.info("Index requested");
        return "index";
    }
    
}
