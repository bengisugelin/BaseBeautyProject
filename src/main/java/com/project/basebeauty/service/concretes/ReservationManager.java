//package com.project.basebeauty.service.concretes;
//
//import com.project.basebeauty.dataAccess.abstracts.ReservationRepository;
//import com.project.basebeauty.entities.concretes.Customer;
//import com.project.basebeauty.entities.concretes.Reservation;
//import com.project.basebeauty.service.abstracts.ReservationService;
//import com.project.basebeauty.service.requests.ReservationRequestDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class ReservationManager implements ReservationService {
//
//    private final ReservationRepository reservationRepository;
//
//    @Autowired
//    public ReservationManager(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }
//
//    @Override
//    public Reservation saveReservation(Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }
//
//    @Override
//    public Reservation getReservationById(Long reservationId) {
//        return reservationRepository.findById(reservationId).orElse(null);
//    }
//
//    @Override
//    public List<Reservation> getAllReservations() {
//        return reservationRepository.findAll();
//    }
//
//    @Override
//    public void deleteReservationById(Long reservationId) {
//        reservationRepository.deleteById(reservationId);
//    }
//
//    @Override
//    public List<Reservation> getReservationsByCustomer(Customer customer) {
//        return reservationRepository.findByCustomer(customer);
//    }
//
//    @Override
//    public Reservation saveReservationRequest(ReservationRequestDto requestDto) {
//        Reservation reservation = new Reservation();
//        reservation.setCalendar(requestDto.getCalendar());
//        reservation.setTime(requestDto.getTime());
//        reservation.setReservationType(requestDto.getReservationType());
//        reservation.setDescription(requestDto.getDescription());
//
//        // Save the image file and set the filename in the reservation entity
//        if (requestDto.getImageFile() != null) {
//            String filename = saveImage(requestDto.getImageFile());
//            reservation.setImage(filename);
//        }
//
//        return reservationRepository.save(reservation);
//    }
//
//    // Utility method to save the uploaded image file and return the filename
//    private String saveImage(MultipartFile imageFile) {
//        if (imageFile != null && !imageFile.isEmpty()) {
//            try {
//                // Generate a unique filename for the image
//                String filename = generateUniqueFilename(imageFile.getOriginalFilename());
//
//                // Save the image file to the "uploads" folder
//                String uploadsDir = "uploads";
//                Path uploadsPath = Paths.get(uploadsDir);
//                if (!Files.exists(uploadsPath)) {
//                    Files.createDirectories(uploadsPath);
//                }
//
//                Path filePath = uploadsPath.resolve(filename);
//                imageFile.transferTo(filePath.toFile());
//
//                return filename;
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle the exception if there's an error while saving the image
//                // For example, you might want to return an error message or throw a custom exception.
//            }
//        }
//        return null;
//    }
//
//    private String generateUniqueFilename(String originalFilename) {
//        // Generate a unique filename by concatenating a timestamp with the original filename
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        return timestamp + extension;
//    }
//}

package com.project.basebeauty.service.concretes;

import com.project.basebeauty.dataAccess.abstracts.ReservationRepository;
import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.entities.concretes.Reservation;
import com.project.basebeauty.service.abstracts.ReservationService;
import com.project.basebeauty.service.requests.ReservationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationManager(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getReservationsByCustomer(Customer customer) {
        return reservationRepository.findByCustomer(customer);
    }

    @Override
    public Reservation saveReservationRequest(ReservationRequestDto requestDto) {
        Reservation reservation = new Reservation();
        reservation.setCalendar(requestDto.getCalendar());

        // Convert the LocalTime object to a string in "HH:mm" format
        reservation.setTime(requestDto.getTime().toString());

        reservation.setReservationType(requestDto.getReservationType());
        reservation.setDescription(requestDto.getDescription());

        // Save the image file and set the filename in the reservation entity
        if (requestDto.getImageFile() != null) {
            String filename = saveImage(requestDto.getImageFile());
            reservation.setImage(filename);
        }

        return reservationRepository.save(reservation);
    }


    private String saveImage(MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                // Generate a unique filename for the image
                String filename = generateUniqueFilename(imageFile.getOriginalFilename());

                // Save the image file to the specified directory
                String directoryPath = "C:/Users/Azinm/OneDrive/Desktop/BB backend/BaseBeautyProject/src/main/resources/images";
                Path directory = Paths.get(directoryPath);
                if (!Files.exists(directory)) {
                    Files.createDirectories(directory);
                }

                Path filePath = directory.resolve(filename);
                imageFile.transferTo(filePath.toFile());

                // Build the complete image URL
                String imageUrl = "http://localhost:8080/images/" + filename;
                return imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception if there's an error while saving the image
                // For example, you might want to return an error message or throw a custom exception.
            }
        }
        return null;
    }

    private String generateUniqueFilename(String originalFilename) {
        String fileExtension = "";
        int lastDotIndex = originalFilename.lastIndexOf(".");
        if (lastDotIndex != -1) {
            fileExtension = originalFilename.substring(lastDotIndex);
        }
        return UUID.randomUUID().toString() + fileExtension;
    }

}
