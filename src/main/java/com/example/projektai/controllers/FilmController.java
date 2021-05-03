package com.example.projektai.controllers;


import com.example.projektai.entity.Film;
import com.example.projektai.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("")
    public ResponseEntity<List<Film>> getFilms(){
        List<Film> films = filmService.getFilms();
        return ResponseEntity.ok(films);
    }
    @PostMapping("/film")
    public ResponseEntity<Film> createFilm(@RequestBody Film film){
        Film createdFilm = filmService.createFilm(film);
        return ResponseEntity.status(201).body(createdFilm);
    }
    @DeleteMapping("/film")
    public ResponseEntity<Film> deleteFilm(@RequestBody Film film){
        Film deletedFilm = filmService.deleteFilm(film);
        return ResponseEntity.ok(deletedFilm);
    }
    @PutMapping("/film")
    public ResponseEntity<Film> updateFilm(@RequestBody Film film){
        Film updatedFilm = filmService.updateFilm(film);
        return ResponseEntity.ok(updatedFilm);
    }

}
