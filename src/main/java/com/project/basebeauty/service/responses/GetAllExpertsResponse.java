package com.project.basebeauty.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllExpertsResponse {

    private String expertImage;
    private String expertFirstName;
    private String expertLastName;
    private String expertServiceArea;
    private String expertDescription;
}
