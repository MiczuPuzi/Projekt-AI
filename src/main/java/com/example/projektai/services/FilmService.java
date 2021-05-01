package com.example.projektai.services;

import com.example.projektai.entity.Film;
import com.example.projektai.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    public Film deleteFilm(Film film) {
        filmRepository.delete(film);
        return film;
    }
    public Film updateFilm(Film film){
        return filmRepository.save(film);
    }

}
