package com.project.basebeauty.service;


import com.project.basebeauty.dataAccess.abstracts.ReservationRepository;
import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.abstracts.ReservationService;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Date reservationDate, Time reservationTime, String expertServiceArea, String description, int customerId) {
        Reservation reservation = new Reservation();
        reservation.setReservationDate(reservationDate);
        reservation.setReservationTime(reservationTime);
        reservation.setExpertServiceArea(expertServiceArea);
        reservation.setDescription(description);
        //reservation.setCustomerId(customerId);

        long generatedId = generateRandomId();
        reservation.setReservationId(generatedId); // ReservationIdを生成

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        // Add your implementation to fetch the reservation by its ID using the reservationRepository
        // For example:
        // return reservationRepository.findById(reservationId);
        return null;
    }



    private long generateRandomId() {
        Random random = new Random();
        long min = 1000000000000000L;
        long max = 9999999999999999L;
        return min + (long) (random.nextDouble() * (max - min + 1));
    }
}