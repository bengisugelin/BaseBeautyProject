package com.project.basebeauty.service.requests;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class ReservationRequestDto {
    private LocalDate calendar;
    private String time; // Change the type to String
    private String reservationType;
    private String description;
    private MultipartFile imageFile;

    // Constructors, Getters, and Setters...

    public LocalDate getCalendar() {
        return calendar;
    }

    public void setCalendar(LocalDate calendar) {
        this.calendar = calendar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
