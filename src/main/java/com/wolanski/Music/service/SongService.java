package com.wolanski.Music.service;

import com.wolanski.Music.entity.Song;

import java.util.List;

// spis funkcji
public interface SongService {

    List<Song> findAll();

    Song findById(int id);

    void save(Song theSong);

    void deleteById(int id);

}
