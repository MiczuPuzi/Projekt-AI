package com.example.projektai.controllers;

import com.example.projektai.entities.Opinion;
import com.example.projektai.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/opinions")
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @GetMapping
    public ResponseEntity<List<Opinion>> getOpinions(){
        List<Opinion> opinions = opinionService.getOpinions();
        return ResponseEntity.ok(opinions);
    }
    @PostMapping
    public ResponseEntity<Opinion> createOpinion(@RequestBody Opinion opinion){
        Opinion createdOpinion = opinionService.createOpinion(opinion);
        return ResponseEntity.status(201).body(createdOpinion);
    }

    @DeleteMapping
    public ResponseEntity<Opinion> deleteOpinion(@RequestBody Opinion opinion){
        Opinion deletedOpinion = opinionService.deleteOpinion(opinion);
        return ResponseEntity.ok(deletedOpinion);
    }
}
