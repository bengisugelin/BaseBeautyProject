package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import com.project.basebeauty.service.requests.CreateExpertRequests;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public List<GetAllExpertsResponse> getAll() {
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

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void add(@RequestPart("expertImage") MultipartFile expertImage,
                    @RequestParam("expertFirstName") String expertFirstName,
                    @RequestParam("expertLastName") String expertLastName,
                    @RequestParam("expertServiceArea") String expertServiceArea,
                    @RequestParam("expertDescription") String expertDescription) {

        CreateExpertRequests createExpertRequests = new CreateExpertRequests(expertFirstName, expertLastName,
                expertServiceArea, expertDescription, expertImage);

        expertService.add(createExpertRequests);
    }
}
