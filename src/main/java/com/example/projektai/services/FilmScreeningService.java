package com.example.projektai.services;

import com.example.projektai.entities.FilmScreening;
import com.example.projektai.repositories.FilmScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmScreeningService {

    @Autowired
    private FilmScreeningRepository filmScreeningRepository;

    public List<FilmScreening> getFilmScreenings() {
        return filmScreeningRepository.findAll();
    }

    public FilmScreening createFilmScreening(FilmScreening filmScreening) {
        return filmScreeningRepository.save(filmScreening);
    }

    public FilmScreening deleteFilmScreening(FilmScreening filmScreening) {
        filmScreeningRepository.delete(filmScreening);
        return filmScreening;
    }

    public FilmScreening updateFilmScreening(FilmScreening filmScreening) {
        return filmScreeningRepository.save(filmScreening);
    }
}
