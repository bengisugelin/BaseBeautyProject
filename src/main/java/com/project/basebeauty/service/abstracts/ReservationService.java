package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Reservation;

import java.sql.Time;
import java.util.Date;

public interface ReservationService {

    Reservation createReservation(Date reservationDate, Time reservationTime, String expertServiceArea, String description, int customerId);

    Reservation getReservationById(int reservationId); // Add the method declaration here
}
