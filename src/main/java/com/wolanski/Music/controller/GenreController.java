package com.wolanski.Music.controller;

import com.wolanski.Music.entity.Genre;
import com.wolanski.Music.entity.Song;
import com.wolanski.Music.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class GenreController {

    private GenreService genreService;
    @Autowired
    public GenreController(GenreService theGenreService){
        genreService = theGenreService;
    }
    @GetMapping("/genre")
    public String genreList(Model theModel){
        List<Genre> genres =  genreService.findAll();
        theModel.addAttribute("genres", genres);
        return "genre-list";
    }

    @GetMapping("/genre/{genre}")
    public String songByGenre(@PathVariable String genre, Model theModel){
        List<Song> songs = genreService.findByGenre(genre);
        theModel.addAttribute("songs", songs);
        return "songByGenre";
    }
}
