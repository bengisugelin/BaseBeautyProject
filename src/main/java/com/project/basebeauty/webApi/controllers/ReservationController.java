package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.dataAccess.abstracts.ExpertRepository;
import com.project.basebeauty.entities.concretes.Expert;
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
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;
    private final ExpertRepository expertRepository;

    @Autowired
    public ReservationController(
            @Qualifier("reservationServiceImpl") ReservationService reservationService,
            ExpertRepository expertRepository) {
        this.reservationService = reservationService;
        this.expertRepository = expertRepository;
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

        List<Expert> experts = expertRepository.findAll();
        model.addAttribute("experts", experts);

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
        Expert selectedExpert = getRandomExpert(reservation.getExpertServiceArea());
        if (selectedExpert == null) {
            // No expert found for the selected service area
            model.addAttribute("errorMessage", "No expert available for the selected service area.");
            return "form_page";
        }

        // data to model
        model.addAttribute("reservationDate", reservation.getReservationDate());
        model.addAttribute("reservationTime", reservation.getReservationTime());

        model.addAttribute("expertId", selectedExpert.getExpertId());

        model.addAttribute("expertName", selectedExpert.getExpertFirstName() + " " + selectedExpert.getExpertLastName());

        model.addAttribute("expertServiceArea", reservation.getExpertServiceArea());
        model.addAttribute("description", reservation.getDescription());


        // insert data in db
        reservationService.createReservation(
                reservation.getReservationDate(),
                reservation.getReservationTime(),
                reservation.getExpertServiceArea(),
                reservation.getDescription(),
                selectedExpert.getExpertId(),
//                reservation.getExpertId(),
                getCustomerId());

        System.out.println("Reservation Date: " + reservation.getReservationDate());
        System.out.println("Reservation Time: " + reservation.getReservationTime());
        System.out.println("Service Area: " + reservation.getExpertServiceArea());
        System.out.println("Description: " + reservation.getDescription());
        System.out.println("Expert Id: " + reservation.getExpertId());

        return "reservation_success_page";
    }

    // Log input values

    private int getCustomerId() {
        // Replace this with your own logic to retrieve the customer ID
        return 1;
    }


    private Expert getRandomExpert(String expertServiceArea) {
        List<Expert> experts = expertRepository.findByExpertServiceArea(expertServiceArea);
        if (!experts.isEmpty()) {
            int randomIndex = new Random().nextInt(experts.size());
            return experts.get(randomIndex);
        }
        // If no expert found for the selected service area, return null or handle appropriately
        return null;
    }
}