package com.example.projektai.services;

import com.example.projektai.entity.Seance;
import com.example.projektai.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;

    public List<Seance> getSeances() {
        return seanceRepository.findAll();
    }

    public Seance createSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    public Seance deleteSeance(Seance seance) {
        seanceRepository.delete(seance);
        return seance;
    }

    public Seance updateSeance(Seance seance) {
        return seanceRepository.save(seance);
    }
}
