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
    private String firstName; // New field for first name
    private String lastName; // New field for last name

    // Other getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
