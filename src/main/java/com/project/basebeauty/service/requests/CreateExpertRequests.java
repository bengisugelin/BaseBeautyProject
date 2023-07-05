package com.project.basebeauty.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpertRequests {

    private String expertFirstName;
    private String expertLastName;
    private String expertServiceArea;
    private String expertDescription;
}
