package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.service.abstracts.ReservationService;
import com.project.basebeauty.service.abstracts.ExpertService;
import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.requests.ReservationRequestDto;
import com.project.basebeauty.service.responses.GetAllExpertsResponse;
import com.project.basebeauty.service.responses.ReservationResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/reservations")
@Api(tags = "Reservation API")
public class ReservationController {

    private final ReservationService reservationService;
    private final ExpertService expertService;

    @Autowired
    public ReservationController(ReservationService reservationService, ExpertService expertService) {
        this.reservationService = reservationService;
        this.expertService = expertService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Create a new reservation with an image upload")
    public ResponseEntity<ReservationResponseDto> saveReservation(
            @ApiParam(value = "Date of the reservation", required = true, example = "2023-07-30")
            @RequestParam("calendar") LocalDate calendar,

            @ApiParam(value = "Time of the reservation as a string",  example = "Any string you want")
            @RequestParam("time") String timeString,

            @ApiParam(value = "Type of the reservation", required = true, example = "makeup")
            @RequestParam("reservationType") String reservationType,

            @ApiParam(value = "Description for the reservation", required = true, example = "This is a makeup appointment.")
            @RequestParam("description") String description,

            @ApiParam(value = "First name of the person making the reservation", required = true, example = "John")
            @RequestParam("firstName") String firstName,

            @ApiParam(value = "Last name of the person making the reservation", required = true, example = "Doe")
            @RequestParam("lastName") String lastName,

            @ApiParam(value = "Image file for the reservation", required = true, example = "sample.jpg")
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        ReservationRequestDto requestDto = new ReservationRequestDto();
        requestDto.setCalendar(calendar);
        requestDto.setTime(timeString); // Store the time as a string directly
        requestDto.setReservationType(reservationType);
        requestDto.setDescription(description);
        requestDto.setImageFile(imageFile);
        requestDto.setFirstName(firstName); // Set the first name
        requestDto.setLastName(lastName); // Set the last name

        Reservation savedReservation = reservationService.saveReservationRequest(requestDto);

        // Get the list of experts based on the reservation type
        List<GetAllExpertsResponse> experts;
        switch (reservationType) {
            case "makeup":
                experts = expertService.getMakeupExperts();
                break;
            case "skincare":
                experts = expertService.getSkinCareExperts();
                break;
            case "nailcare":
                experts = expertService.getNailCareExperts();
                break;
            default:
                experts = Collections.emptyList();
        }

        // Randomly select an expert from the list
        GetAllExpertsResponse selectedExpert = null;
        if (!experts.isEmpty()) {
            int randomIndex = new Random().nextInt(experts.size());
            selectedExpert = experts.get(randomIndex);
        }

        // Create and return the response DTO
        ReservationResponseDto responseDto = new ReservationResponseDto();
        responseDto.setReservationId(savedReservation.getReservationId());
        responseDto.setCalendar(savedReservation.getCalendar());
        responseDto.setTime(timeString); // Use the original timeString as the response
        responseDto.setReservationType(savedReservation.getReservationType());
        responseDto.setDescription(savedReservation.getDescription());
        responseDto.setImageUrl(savedReservation.getImage());
        responseDto.setExpert(selectedExpert); // Set the expert field with the selected expert
        responseDto.setFirstName(firstName); // Set the first name in the response
        responseDto.setLastName(lastName); // Set the last name in the response

        return ResponseEntity.ok(responseDto);
    }
}
