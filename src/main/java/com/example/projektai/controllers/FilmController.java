package com.example.projektai.controllers;

import com.example.projektai.entities.Film;
import com.example.projektai.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public ResponseEntity<List<Film>> getFilms(){
        List<Film> films = filmService.getFilms();
        return ResponseEntity.ok(films);
    }
    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film){
        Film createdFilm = filmService.createFilm(film);
        return ResponseEntity.status(201).body(createdFilm);
    }
    @DeleteMapping
    public ResponseEntity<Film> deleteFilm(@RequestBody Film film){
        Film deletedFilm = filmService.deleteFilm(film);
        return ResponseEntity.ok(deletedFilm);
    }
    @PutMapping
    public ResponseEntity<Film> updateFilm(@RequestBody Film film){
        Film updatedFilm = filmService.updateFilm(film);
        return ResponseEntity.ok(updatedFilm);
    }
}
