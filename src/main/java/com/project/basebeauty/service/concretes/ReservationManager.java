package com.project.basebeauty.service.concretes;

import com.project.basebeauty.exception.ReservationCreationException;
import com.project.basebeauty.dataAccess.abstracts.ReservationRepository;
import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.abstracts.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Time;
import java.util.Date;
@Service
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository) {
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

        try {
            return reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new ReservationCreationException("Error during the process", e);
        }
    }



    @Override
    public Reservation getReservationById(int reservationId) {

        return null;
    }


}

@ControllerAdvice
@Component("reservationCreationExceptionHandler")
class ReservationCreationExceptionHandler {
    @ExceptionHandler(ReservationCreationException.class)
    public ResponseEntity<String> handleReservationCreationException(ReservationCreationException ex) {
        String errorMessage = "Error";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}