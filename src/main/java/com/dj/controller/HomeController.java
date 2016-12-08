package com.dj.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by DJ on 11/9/16.
 */
@Controller
public class HomeController {
    private static final Logger LOG = LogManager.getLogger(HomeController.class);
    
    @RequestMapping("/")
    public String index() {
        LOG.info("Index requested");
        return "index";
    }
    
}
