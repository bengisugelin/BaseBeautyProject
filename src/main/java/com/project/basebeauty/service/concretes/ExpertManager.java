package com.project.basebeauty.service.concretes;

import com.project.basebeauty.dataAccess.abstracts.ExpertRepository;
import com.project.basebeauty.entities.concretes.Expert;
import com.project.basebeauty.service.abstracts.ExpertService;
import com.project.basebeauty.service.requests.CreateExpertRequests;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ExpertManager implements ExpertService {

    private ExpertRepository expertRepository;

    @Autowired
    public ExpertManager(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }

    @Override
    public List<GetAllExpertsResponse> getAll() {
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> expertResponses = new ArrayList<>();
        for (Expert expert : experts) {
            GetAllExpertsResponse expertResponse = new GetAllExpertsResponse();
            expertResponse.setExpertFirstName(expert.getExpertFirstName());
            expertResponse.setExpertLastName(expert.getExpertLastName());
            expertResponse.setExpertServiceArea(expert.getExpertServiceArea());
            expertResponse.setExpertDescription(expert.getExpertDescription());
            expertResponse.setExpertImage(getExpertImageUrl(expert.getExpertImageFilename()));
            expertResponses.add(expertResponse);
        }
        return expertResponses;
    }

    @Override
    public List<GetAllExpertsResponse> getMakeupExperts() {
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> makeupExpertResponse = new ArrayList<>();
        for (Expert expert : experts) {
            if (expert.getExpertServiceArea().equals("makeup")) {
                GetAllExpertsResponse makeupResponseItem = new GetAllExpertsResponse();
                makeupResponseItem.setExpertFirstName(expert.getExpertFirstName());
                makeupResponseItem.setExpertLastName(expert.getExpertLastName());
                makeupResponseItem.setExpertDescription(expert.getExpertDescription());
                makeupResponseItem.setExpertServiceArea(expert.getExpertServiceArea());
                makeupResponseItem.setExpertImage(getExpertImageUrl(expert.getExpertImageFilename()));
                makeupExpertResponse.add(makeupResponseItem);
            }
        }
        return makeupExpertResponse;
    }

    @Override
    public List<GetAllExpertsResponse> getSkinCareExperts() {
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> skinCareExpertResponse = new ArrayList<>();
        for (Expert expert : experts) {
            if (expert.getExpertServiceArea().equals("skincare")) {
                GetAllExpertsResponse skinCareResponseItem = new GetAllExpertsResponse();
                skinCareResponseItem.setExpertFirstName(expert.getExpertFirstName());
                skinCareResponseItem.setExpertLastName(expert.getExpertLastName());
                skinCareResponseItem.setExpertDescription(expert.getExpertDescription());
                skinCareResponseItem.setExpertServiceArea(expert.getExpertServiceArea());
                skinCareResponseItem.setExpertImage(getExpertImageUrl(expert.getExpertImageFilename()));
                skinCareExpertResponse.add(skinCareResponseItem);
            }
        }
        return skinCareExpertResponse;
    }

    @Override
    public List<GetAllExpertsResponse> getNailCareExperts() {
        List<Expert> experts = expertRepository.findAll();
        List<GetAllExpertsResponse> nailCareExpertResponse = new ArrayList<>();
        for (Expert expert : experts) {
            if (expert.getExpertServiceArea().equals("nailcare")) {
                GetAllExpertsResponse nailCareResponseItem = new GetAllExpertsResponse();
                nailCareResponseItem.setExpertFirstName(expert.getExpertFirstName());
                nailCareResponseItem.setExpertLastName(expert.getExpertLastName());
                nailCareResponseItem.setExpertDescription(expert.getExpertDescription());
                nailCareResponseItem.setExpertServiceArea(expert.getExpertServiceArea());
                nailCareResponseItem.setExpertImage(getExpertImageUrl(expert.getExpertImageFilename()));
                nailCareExpertResponse.add(nailCareResponseItem);
            }
        }
        return nailCareExpertResponse;
    }

    private String getExpertImageUrl(String expertImageFilename) {
        String baseUrl = "http://localhost:8080/api/experts/images/"; // Replace with your actual base URL
        return baseUrl + expertImageFilename;
    }

    @Override
    public void add(CreateExpertRequests createExpertRequests) {
        String expertFirstName = createExpertRequests.getExpertFirstName();
        String expertLastName = createExpertRequests.getExpertLastName();
        String expertServiceArea = createExpertRequests.getExpertServiceArea();
        String expertDescription = createExpertRequests.getExpertDescription();
        MultipartFile expertImage = createExpertRequests.getExpertImage();

        Expert expert = new Expert();
        expert.setExpertFirstName(expertFirstName);
        expert.setExpertLastName(expertLastName);
        expert.setExpertServiceArea(expertServiceArea);
        expert.setExpertDescription(expertDescription);

        String expertImageFilename = saveExpertImage(expertImage);
        expert.setExpertImageFilename(expertImageFilename);

        expertRepository.save(expert);
    }

    private String saveExpertImage(MultipartFile expertImage) {
        String expertImageFilename = null;
        try {
            // Generate a unique filename or identifier for the image
            expertImageFilename = generateUniqueFilename();

            // Save the image file to the specified directory
            String directoryPath = "src/main/resources/images/";
            Path directory = Paths.get(directoryPath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            Path imagePath = directory.resolve(expertImageFilename);
            Files.write(imagePath, expertImage.getBytes());

            // If the image was saved successfully, return the filename
            return expertImageFilename;
        } catch (IOException e) {
            // Handle the exception and return null or throw a custom exception
            e.printStackTrace();
        }
        return expertImageFilename;
    }


    private String generateUniqueFilename() {
        // Generate a unique filename or identifier for the image
        // You can use various methods like UUID.randomUUID() or timestamp-based approaches
        return UUID.randomUUID().toString() + ".jpg";
    }
}
