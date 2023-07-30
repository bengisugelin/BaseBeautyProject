package com.project.basebeauty.service.responses;

import java.time.LocalDate;
import java.time.LocalTime;

import com.project.basebeauty.entities.concretes.Expert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {
    private Long reservationId;
    private LocalDate calendar;
    private String time;
    private String reservationType;
    private String description;
    private String imageUrl;
    private GetAllExpertsResponse expert; // Change the type here

    // Other getters and setters
}