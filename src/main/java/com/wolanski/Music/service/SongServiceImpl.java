package com.wolanski.Music.service;

import com.wolanski.Music.dao.SongRepository;
import com.wolanski.Music.entity.Song;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// przypisanie do funkcji z service z spring boot z ktorym polaczylem sie w SongRepository
@Service
public class SongServiceImpl implements SongService{

    private SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository theSongRepository){
        songRepository = theSongRepository;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        Optional<Song> result = songRepository.findById(id);

        Song tempSong = new Song();
        if(result.isPresent()){
            tempSong = result.get();
        }
        else {
            throw new RuntimeException("Song with id " + id + "was not found");
        }
        return tempSong;
    }

    @Override
    public void save(Song theSong) {
        songRepository.save(theSong);
    }

    @Override
    public void deleteById(int id) {
        songRepository.deleteById(id);
    }


}
