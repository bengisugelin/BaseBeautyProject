package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import com.project.basebeauty.service.requests.CreateExpertRequests;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experts")
public class ExpertsController {

    private ExpertService expertService;


    @Autowired
    public ExpertsController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/getallexperts")
    public List<GetAllExpertsResponse> getAll(){

        return expertService.getAll();
    }

    @GetMapping("/getmakeupexperts")
    public List<GetAllExpertsResponse> getMakeupExperts() {
        return expertService.getMakeupExperts();
    }

    @GetMapping("/getskincareexperts")
    public List<GetAllExpertsResponse> getSkinCareExperts() {
        return expertService.getSkinCareExperts();
    }

    @GetMapping("/getnailcareexperts")
    public List<GetAllExpertsResponse> getNailCareExperts() {
        return expertService.getNailCareExperts();
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateExpertRequests createExpertRequests){
        this.expertService.add(createExpertRequests);
    }
}
