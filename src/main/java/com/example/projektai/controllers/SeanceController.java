package com.example.projektai.controllers;

import com.example.projektai.entity.Seance;
import com.example.projektai.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @GetMapping("")
    public ResponseEntity<List<Seance>> getSeances(){
        List<Seance> seances = seanceService.getSeances();
        return ResponseEntity.ok(seances);
    }
    @PostMapping("/seance")
    public ResponseEntity<Seance> createSeance(@RequestBody Seance seance){
        Seance createdSeance = seanceService.createSeance(seance);
        return ResponseEntity.status(201).body(createdSeance);
    }
    @DeleteMapping("/seance")
    public ResponseEntity<Seance> deleteSeance(@RequestBody Seance seance){
        Seance deletedSeance = seanceService.deleteSeance(seance);
        return ResponseEntity.ok(deletedSeance);
    }
    @PutMapping("/seance")
    public ResponseEntity<Seance> updatedSeance(@RequestBody Seance seance){
        Seance updatedSeance = seanceService.updateSeance(seance);
        return ResponseEntity.ok(updatedSeance);
    }
}
