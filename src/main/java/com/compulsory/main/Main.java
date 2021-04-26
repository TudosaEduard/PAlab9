package com.compulsory.main;

import com.compulsory.entity.Genre;
import com.compulsory.entity.Movie;
import com.compulsory.repository.GenresEntityMethods;
import com.compulsory.repository.MoviesEntityMethods;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String str = "2022-09-01";

        Genre genresEntity = new Genre();
        genresEntity.setType("Macarena");

        Movie moviesEntity = new Movie();
        moviesEntity.setDuration(120);
        moviesEntity.setScore(10);
        moviesEntity.setTitle("The Conjuring");
        moviesEntity.setReleaseDate(str);


        GenresEntityMethods genresEntityMethods = new GenresEntityMethods();
        genresEntityMethods.create(genresEntity);

        MoviesEntityMethods moviesEntityMethods = new MoviesEntityMethods();
        moviesEntityMethods.create(moviesEntity);

        genresEntityMethods.findById(genresEntity);
        genresEntityMethods.findByName(genresEntity);
    }
}


