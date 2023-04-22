package com.wolanski.Music.service;

import com.wolanski.Music.dao.GenreRepository;
import com.wolanski.Music.entity.Genre;
import com.wolanski.Music.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GenreServiceImpl implements GenreService{

    private GenreRepository genreRepository;
    @Autowired
    public GenreServiceImpl(GenreRepository theGenreRepository){
        genreRepository = theGenreRepository;
    }
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(int id) {
        Optional<Genre> result = genreRepository.findById(id);
        Genre genre = new Genre();
        if(result.isPresent()){
            genre = result.get();
        }
        else throw new RuntimeException("Genre with id " + id + " was not found");
        return genre;
    }

    @Override
    public void save(Genre theGenre) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Song> findByGenre(String name) {
        return genreRepository.findByGenre(name);
    }
}
