package com.dj.controller;

import com.dj.model.PurchaseWebsite;
import com.dj.repository.PurchaseWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zterwort on 12/11/16.
 */
public class PurchaseWebsiteController {

    @Autowired
    private PurchaseWebsiteRepository purchaseWebsiteRepository;

    @RequestMapping(value = "{purchase}", method = RequestMethod.GET)
    public String findByName(@PathVariable(value = "purchase") String title, Model model) {
        String name = title.replace("_", " ");
        PurchaseWebsite test = purchaseWebsiteRepository.findByName(name);
        model.addAttribute("purchase", test);

        return "purchases/purchase";
    }
}
