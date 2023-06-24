package com.project.basebeauty.service.concretes;

import com.project.basebeauty.dataAccess.abstracts.ExpertRepository;
import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import com.project.basebeauty.service.requests.CreateExpertRequests;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
            responseItem.setExpertDescription(expert.getExpertDescription());
            responseItem.setExpertServiceArea(expert.getExpertServiceArea());
            expertResponse.add(responseItem);
        }
        return expertResponse;
    }

    @Override
    public List<GetAllExpertsResponse> getMakeupExperts(){
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> makeupExpertResponse =  new ArrayList<GetAllExpertsResponse>();
        for (Expert expert : experts) {

            if (expert.getExpertServiceArea().equals("makeup")){
                GetAllExpertsResponse makeupResponseItem = new GetAllExpertsResponse();
                makeupResponseItem.setExpertFirstName(expert.getExpertFirstName());
                makeupResponseItem.setExpertLastName(expert.getExpertLastName());
                makeupResponseItem.setExpertDescription(expert.getExpertDescription());
                makeupResponseItem.setExpertServiceArea(expert.getExpertServiceArea());
                makeupExpertResponse.add(makeupResponseItem);
            }
        }

        return makeupExpertResponse;
    }

    @Override
    public List<GetAllExpertsResponse> getSkinCareExperts(){
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> skinCareExpertResponse =  new ArrayList<GetAllExpertsResponse>();
        for (Expert expert : experts) {

            if (expert.getExpertServiceArea().equals("skincare")){
                GetAllExpertsResponse skinCareResponseItem = new GetAllExpertsResponse();
                skinCareResponseItem.setExpertFirstName(expert.getExpertFirstName());
                skinCareResponseItem.setExpertLastName(expert.getExpertLastName());
                skinCareResponseItem.setExpertDescription(expert.getExpertDescription());
                skinCareResponseItem.setExpertServiceArea(expert.getExpertServiceArea());
                skinCareExpertResponse.add(skinCareResponseItem);
            }
        }

        return skinCareExpertResponse;
    }

    @Override
    public List<GetAllExpertsResponse> getNailCareExperts() {

        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> nailCareExpertResponse =  new ArrayList<GetAllExpertsResponse>();
        for (Expert expert : experts) {

            if (expert.getExpertServiceArea().equals("nailcare")){
                GetAllExpertsResponse nailCareResponseItem = new GetAllExpertsResponse();
                nailCareResponseItem.setExpertFirstName(expert.getExpertFirstName());
                nailCareResponseItem.setExpertLastName(expert.getExpertLastName());
                nailCareResponseItem.setExpertDescription(expert.getExpertDescription());
                nailCareResponseItem.setExpertServiceArea(expert.getExpertServiceArea());
                nailCareExpertResponse.add(nailCareResponseItem);
            }
        }

        return nailCareExpertResponse;
    }


    @Override
    public void add(CreateExpertRequests createExpertRequests) {

       Expert expert = new Expert();
       expert.setExpertFirstName(createExpertRequests.getExpertFirstName());
       expert.setExpertLastName(createExpertRequests.getExpertLastName());
       expert.setExpertDescription(createExpertRequests.getExpertDescription());
       expert.setExpertServiceArea(createExpertRequests.getExpertServiceArea());


        this.expertRepository.save(expert);
    }
}
