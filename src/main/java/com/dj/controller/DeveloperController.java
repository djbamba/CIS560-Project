package com.dj.controller;

import com.dj.model.Developer;
import com.dj.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        Developer test = developerRepository.findByName(name);
        model.addAttribute("developer", test);

        return "developers/developer";
    }
}
