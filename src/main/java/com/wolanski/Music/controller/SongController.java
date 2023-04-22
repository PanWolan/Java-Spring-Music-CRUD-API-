package com.wolanski.Music.controller;

import com.wolanski.Music.entity.Genre;
import com.wolanski.Music.entity.Song;
import com.wolanski.Music.service.GenreService;
import com.wolanski.Music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// mapping do Song
@Controller
@RequestMapping("/api")
public class SongController {


    private SongService songService;
    private GenreService genreService;
    @Autowired
    public SongController(SongService theSongService, GenreService theGenreService){

        songService=theSongService;
        genreService = theGenreService;
    }


    @GetMapping("/song")
    public String SongList(Model theModel){
        List<Song> songs = songService.findAll();
        theModel.addAttribute("songs", songs);

        return "song-list";
    }

    @GetMapping("/song/{id}")
    public String SongById(@PathVariable int id, Model theModel){
        Song song = songService.findById(id);
        theModel.addAttribute("song", song);
        return "songById";
    }

    @GetMapping("/song/addSongForm")
    public String addSongForm(Model theModel){

        Song song = new Song();
        theModel.addAttribute("song", song);
        List<Genre> genres = genreService.findAll();
        theModel.addAttribute("genres", genres);
        return "songAddForm";
    }

    @PostMapping("/song/save")
    public String saveSong(@ModelAttribute("song") Song theSong, Model theModel){
        List<Genre> genres = genreService.findAll();
        theModel.addAttribute("genres", genres);
        songService.save(theSong);

        return "redirect:/api/song";
    }

    @GetMapping("/song/showFormForUpdate")
    public String updateSong(@RequestParam("songId") int id, Model theModel){
       Song song = songService.findById(id);
       theModel.addAttribute("song", song);
       List<Genre> genres = genreService.findAll();
       theModel.addAttribute("genres", genres);
       return "songAddForm";
    }

    @GetMapping("/song/delete")
    public String delete(@RequestParam("songId") int theId){
        songService.deleteById(theId);
        return "redirect:/api/song";
    }
}
