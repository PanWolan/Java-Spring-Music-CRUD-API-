package com.wolanski.Music.dao;

import com.wolanski.Music.entity.Genre;
import com.wolanski.Music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Integer> {

    @Query("select song from com.wolanski.Music.entity.Song song where song.genre.name = :name" )
    List<Song> findByGenre(String name);
}
