package com.project.basebeauty.exception;


import com.project.basebeauty.dataAccess.abstracts.ReservationRepository;
import com.project.basebeauty.entities.concretes.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final ReservationRepository reservationRepository;

    public GlobalExceptionHandler(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @ExceptionHandler(ReservationCreationException.class)
    public ResponseEntity<String> handleReservationCreationException(ReservationCreationException ex) {

        String errorMessage = "Error";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }


    public Reservation createReservation(Reservation reservation) {
        try {
            // data to database
            return reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new ReservationCreationException("予約の作成中にエラーが発生しました。", e);
        }
    }
}
