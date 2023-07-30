package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.requests.ReservationRequestDto;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    Reservation getReservationById(Long reservationId);

    List<Reservation> getAllReservations();

    void deleteReservationById(Long reservationId);

    List<Reservation> getReservationsByCustomer(Customer customer);

    // Additional method to save a reservation request
    Reservation saveReservationRequest(ReservationRequestDto requestDto);
}