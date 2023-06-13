package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/experts")
public class ExpertsController {

    private ExpertService expertService;


    @Autowired
    public ExpertsController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/getall")
    public List<Expert> getAll(){
        return expertService.getAll();
    }
}
