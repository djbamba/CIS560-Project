package com.dj.controller;

import com.dj.model.Publisher;
import com.dj.model.System;
import com.dj.repository.PublisherRepository;
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
@RequestMapping("publisher/")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping(value = "{publisher}", method = RequestMethod.GET)
    public String findByName(@PathVariable(value = "publisher") String title, Model model) {
        String name = title.replace("_", " ");
        Publisher test = publisherRepository.findByName(name);
        model.addAttribute("publisher", test);

        return "publishers/publisher";
    }
}
