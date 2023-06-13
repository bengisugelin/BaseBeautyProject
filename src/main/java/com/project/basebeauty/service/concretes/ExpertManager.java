package com.project.basebeauty.service.concretes;

import com.project.basebeauty.dataAccess.abstracts.ExpertRepository;
import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // this class is a business object
public class ExpertManager implements ExpertService {

    private ExpertRepository expertRepository;

   @Autowired
    public ExpertManager(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }


    @Override
    public List<Expert> getAll() {
        //business rules will be here
        return expertRepository.getAll();
    }
}
