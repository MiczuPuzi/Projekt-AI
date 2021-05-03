package com.example.projektai.services;

import com.example.projektai.entity.Opinion;
import com.example.projektai.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService {

    @Autowired
    private OpinionRepository opinionRepository;

    public List<Opinion> getOpinions() {
        return opinionRepository.findAll();
    }

    public Opinion createOpinion(Opinion opinion) {
        return opinionRepository.save(opinion);
    }

    public Opinion deleteOpinion(Opinion opinion) {
        opinionRepository.delete(opinion);
        return opinion;
    }

    public Opinion updateOpinion(Opinion opinion) {
        return opinionRepository.save(opinion);
    }

}
