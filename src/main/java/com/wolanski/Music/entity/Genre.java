package com.wolanski.Music.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenre")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<>();

    public Genre(){

    }
    public Genre(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
