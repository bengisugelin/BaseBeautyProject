package com.project.basebeauty.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllExpertsResponse {

    private String expertFirstName;
    private String expertLastName;
    private String expertServiceArea; //cruelty-free, acne-prone etc.
    private String expertDescription;
}
