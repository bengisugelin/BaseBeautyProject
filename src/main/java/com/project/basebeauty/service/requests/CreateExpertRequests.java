package com.project.basebeauty.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpertRequests {

    private String expertFirstName;
    private String expertLastName;
    private String expertServiceArea;
    private String expertDescription;
    private MultipartFile expertImage;

    public void setExpertImage(MultipartFile expertImage) {
        this.expertImage = expertImage;
    }
}
