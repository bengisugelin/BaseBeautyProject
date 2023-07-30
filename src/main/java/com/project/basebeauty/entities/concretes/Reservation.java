
package com.project.basebeauty.entities.concretes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "calendar")
    private LocalDate calendar;

    @Column(name = "time")
    private String time; // Change the type to String to accept any string representation of time

    @Column(name = "reservation_type")
    private String reservationType; // makeup, nailcare, skincare

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Assuming there's a column named 'customer_id' in the 'reservations' table to store the foreign key
    private Customer customer;

    // Constructors, Getters, and Setters...

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
