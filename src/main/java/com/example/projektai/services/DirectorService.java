package com.example.projektai.services;

import com.example.projektai.entity.Director;
import com.example.projektai.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> getDirectors() {
        return directorRepository.findAll();
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director deleteDirector(Director director) {
        directorRepository.delete(director);
        return director;
    }

    public Director updateDirector(Director director) {
        return directorRepository.save(director);
    }
}
