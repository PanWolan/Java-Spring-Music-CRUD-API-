package com.wolanski.Music.service;

import com.wolanski.Music.entity.Genre;
import com.wolanski.Music.entity.Song;


import java.util.List;

public interface GenreService {
    List<Genre> findAll();

    Genre findById(int id);

    void save(Genre theGenre);

    void deleteById(int id);

    List<Song> findByGenre(String name);
}
