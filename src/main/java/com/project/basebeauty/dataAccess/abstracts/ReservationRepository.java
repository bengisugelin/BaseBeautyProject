package com.project.basebeauty.dataAccess.abstracts;

import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomer(Customer customer);
    // You can define other custom queries or methods here if needed
}

