package com.project.basebeauty.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpertResponseDto {
    private Long expertId;
    private String expertImage;
    private String expertFirstName;
    private String expertLastName;
    private String expertServiceArea;
    private String expertDescription;
}
