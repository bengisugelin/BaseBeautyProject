package com.project.basebeauty.dataAccess.abstracts;

public class ReservationCreationException extends RuntimeException {
    public ReservationCreationException(String message, Exception cause) {
        super(message, cause);
    }
}
