package com.wolanski.Music.entity;

import jakarta.persistence.*;

// przedstawienie tabeli jako klasy
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsong")
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "album")
    private String album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genreid")
    private Genre genre;

    public Song(){

    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Song(String author, String title, String album, Genre genre) {
        this.author = author;
        this.title = title;
        this.album = album;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", genre=" + genre +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenreName(){
        return this.genre.getName();
    }


}
