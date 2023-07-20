package com.project.basebeauty.dataAccess.abstracts;


import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.abstracts.ReservationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // 追加のメソッドの宣言
}

