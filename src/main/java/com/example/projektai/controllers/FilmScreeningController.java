package com.example.projektai.controllers;

import com.example.projektai.entities.FilmScreening;
import com.example.projektai.services.FilmScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/FilmScreenings")
public class FilmScreeningController {

    @Autowired
    private FilmScreeningService filmScreeningService;

    @GetMapping
    public ResponseEntity<List<FilmScreening>> getFilmScreenings(){
        List<FilmScreening> filmScreenings = filmScreeningService.getFilmScreenings();
        return ResponseEntity.ok(filmScreenings);
    }
    @PostMapping
    public ResponseEntity<FilmScreening> createFilmScreening(@RequestBody FilmScreening filmScreening){
        FilmScreening createdFilmScreening = filmScreeningService.createFilmScreening(filmScreening);
        return ResponseEntity.status(201).body(createdFilmScreening);
    }
    @DeleteMapping
    public ResponseEntity<FilmScreening> deleteFilmScreening(@RequestBody FilmScreening filmScreening){
        FilmScreening deletedFilmScreening = filmScreeningService.deleteFilmScreening(filmScreening);
        return ResponseEntity.ok(deletedFilmScreening);
    }
    @PutMapping
    public ResponseEntity<FilmScreening> updatedFilmScreening(@RequestBody FilmScreening filmScreening){
        FilmScreening updatedFilmScreening = filmScreeningService.updateFilmScreening(filmScreening);
        return ResponseEntity.ok(updatedFilmScreening);
    }
}
