package com.dj.controller;

import com.dj.model.System;
import com.dj.repository.SystemRepository;
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
@RequestMapping("system/")
public class SystemController {

    @Autowired
    private SystemRepository systemRepository;

    @RequestMapping(value = "{system}", method = RequestMethod.GET)
    public String getSystemByName(@PathVariable(value = "system") String title, Model model) {
        String name = title.replace("_", " ");
        System test = systemRepository.findByName(name);
        model.addAttribute("system", test);

        return "systems/system";
    }
}
