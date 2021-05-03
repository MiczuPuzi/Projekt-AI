package com.example.projektai.controllers;

import com.example.projektai.entity.Director;
import com.example.projektai.entity.Opinion;
import com.example.projektai.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping("")
    public ResponseEntity<List<Director>> getDirectors(){
        List<Director> directors = directorService.getDirectors();
        return ResponseEntity.ok(directors);
    }
    @PostMapping("/director")
    public ResponseEntity<Director> createOpinion(@RequestBody Director director){
        Director createdDirector = directorService.createDirector(director);
        return ResponseEntity.status(201).body(createdDirector);
    }

    @DeleteMapping("/director")
    public ResponseEntity<Director> deleteOpinion(@RequestBody Director director){
        Director deletedDirector = directorService.deleteDirector(director);
        return ResponseEntity.ok(deletedDirector);
    }

    @PutMapping("/director")
    public ResponseEntity<Director> updateOpinion(@RequestBody Director director){
        Director updatedDirector = directorService.updateDirector(director);
        return ResponseEntity.ok(updatedDirector);
    }
}
