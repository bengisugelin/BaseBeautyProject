package com.project.basebeauty.service.concretes;

import com.project.basebeauty.dataAccess.abstracts.ExpertRepository;
import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import com.project.basebeauty.service.requests.CreateExpertRequests;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // this class is a business object
public class ExpertManager implements ExpertService {

    private ExpertRepository expertRepository;

   @Autowired
    public ExpertManager(ExpertRepository expertRepository) {

       this.expertRepository = expertRepository;
    }


    @Override
    public List<GetAllExpertsResponse> getAll() {
        //business rules will be here
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> expertResponse =  new ArrayList<GetAllExpertsResponse>();
        for (Expert expert : experts) {

            GetAllExpertsResponse responseItem = new GetAllExpertsResponse();
            responseItem.setExpertFirstName(expert.getExpertFirstName());
            responseItem.setExpertLastName(expert.getExpertLastName());
            responseItem.setExpertServiceArea(expert.getExpertServiceArea());
            expertResponse.add(responseItem);
        }
        return expertResponse;
    }

    @Override
    public void add(CreateExpertRequests createExpertRequests) {

       Expert expert = new Expert();
       expert.setExpertFirstName(createExpertRequests.getExpertFirstName());
       expert.setExpertLastName(createExpertRequests.getExpertLastName());
       expert.setExpertServiceArea(createExpertRequests.getExpertServiceArea());


        this.expertRepository.save(expert);
    }
}
