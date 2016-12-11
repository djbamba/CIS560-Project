package com.dj.controller;

import com.dj.model.ScoreWebsite;
import com.dj.repository.ScoreWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DJ on 11/23/16.
 */
public class ScoreWebsiteController {

    @Autowired
    private ScoreWebsiteRepository scoreWebsiteRepository;

    @RequestMapping(value = "{score}", method = RequestMethod.GET)
    public String findByName(@PathVariable(value = "score") String title, Model model) {
        String name = title.replace("_", " ");
        ScoreWebsite test = scoreWebsiteRepository.findByName(name);
        model.addAttribute("score", test);

        return "scores/score";
    }
}
