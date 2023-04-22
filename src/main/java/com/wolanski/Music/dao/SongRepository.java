package com.wolanski.Music.dao;

import com.wolanski.Music.entity.Genre;
import com.wolanski.Music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Polaczenie z springboot repository
@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {


}

//wiecej nic nie trzeba robic