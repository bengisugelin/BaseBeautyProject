package com.project.basebeauty.exception;

public class ReservationCreationException extends RuntimeException {
    public ReservationCreationException(String message, Exception cause) {
        super(message, cause);
    }
}
