package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.dataAccess.abstracts.ReservationRepository;
import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.entities.concretes.Reservation;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.Random;

public interface ReservationService {


    Reservation createReservation(Date reservationDate, Time reservationTime, String expertServiceArea, String description, int customerId);


    Reservation getReservationById(int reservationId); // Add the method declaration here
;
}
