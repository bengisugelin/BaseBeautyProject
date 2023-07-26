package com.project.basebeauty.webApi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.abstracts.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(@Qualifier("reservationServiceImpl") ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(dateFormat.parse(text));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });

        binder.registerCustomEditor(Time.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(new Time(timeFormat.parse(text).getTime()));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });
    }

    @GetMapping("/form")
    public String showFormPage(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "form_page";
    }

    @PostMapping("/form")
    public String processFormSubmission(
            @ModelAttribute("reservation") @Valid Reservation reservation,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            // error message to console
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            return "form_page";
        }

        int customerId = getCustomerId();
        String expertName = generateRandomExpertName();

        // data to model
        model.addAttribute("reservationDate", reservation.getReservationDate());
        model.addAttribute("reservationTime", reservation.getReservationTime());
        model.addAttribute("expertName", expertName);
        model.addAttribute("expertServiceArea", reservation.getExpertServiceArea());
        model.addAttribute("description", reservation.getDescription());


        // insert data in db
        reservationService.createReservation(
                reservation.getReservationDate(),
                reservation.getReservationTime(),
                reservation.getExpertServiceArea(),
                reservation.getDescription(),
                customerId);

        System.out.println("Reservation Date: " + reservation.getReservationDate());
        System.out.println("Reservation Time: " + reservation.getReservationTime());
        System.out.println("Service Area: " + reservation.getExpertServiceArea());
        System.out.println("Description: " + reservation.getDescription());

        return "reservation_success_page";
    }

    // Log input values

    private int getCustomerId() {
        // Replace this with your own logic to retrieve the customer ID
        return 1;
    }

    private String generateRandomExpertName() {
        // just for now
        return "John Doe";
    }
}
