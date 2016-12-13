package com.dj.controller;

import com.dj.model.Genre;
import com.dj.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */
@Controller
@RequestMapping("genre/")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping(value = "{genre}", method = RequestMethod.GET)
    public String findByGenre(@PathVariable(value = "genre") String title, Model model) {
        String name = title.replace("_", " ");
        Genre test = genreRepository.findByGenre(name);
        model.addAttribute("genre",test);

        return "genres/genre";
    }


}
