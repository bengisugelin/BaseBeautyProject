package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.abstracts.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(@Qualifier("reservationServiceImpl") ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/form")
    public String showFormPage(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "form_page";
    }


    private int getCustomerId() {
        // Replace this with your own logic to retrieve the customer ID
        return 1;
    }
    @PostMapping("/reservation_success_page")
    public String submitReservation(
            @ModelAttribute("reservation") @Valid Reservation reservation,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "reservation_success_page";
        }

        int customerId = getCustomerId();

        // Expert画面に表示するダミーのExpert名（適当な人名）
        String expertName = generateRandomExpertName();

        // モデルにデータを設定
        model.addAttribute("reservationDate", reservation.getReservationDate());
        model.addAttribute("reservationTime", reservation.getReservationTime());
        model.addAttribute("expertServiceArea", reservation.getExpertServiceArea());
        model.addAttribute("description", reservation.getDescription());
        model.addAttribute("expertName", expertName);

        // insert data in db
        reservationService.createReservation(
                reservation.getReservationDate(),
                reservation.getReservationTime(),
                reservation.getExpertServiceArea(),
                reservation.getDescription(),
                customerId
        );

        // redirect to success page
        return "reservation_success_page";
    }


    private String generateRandomExpertName() {
//just for now
        return "John Doe";
    }
}