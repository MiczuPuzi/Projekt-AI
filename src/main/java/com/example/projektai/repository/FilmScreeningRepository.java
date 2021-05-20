package com.example.projektai.repository;

import com.example.projektai.entity.FilmScreening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmScreeningRepository extends JpaRepository<FilmScreening,Long> {
}
