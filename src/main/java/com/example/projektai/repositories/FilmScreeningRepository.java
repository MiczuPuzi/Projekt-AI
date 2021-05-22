package com.example.projektai.repositories;

import com.example.projektai.entities.FilmScreening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmScreeningRepository extends JpaRepository<FilmScreening,Long> {
}
