package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.requests.CreateExpertRequests;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ExpertService {

    List<GetAllExpertsResponse> getAll();

     List<GetAllExpertsResponse> getMakeupExperts();

    public List<GetAllExpertsResponse> getSkinCareExperts();

    public List<GetAllExpertsResponse> getNailCareExperts();

    void add(CreateExpertRequests createExpertRequests);
}
