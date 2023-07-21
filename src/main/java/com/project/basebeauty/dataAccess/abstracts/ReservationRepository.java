package com.project.basebeauty.dataAccess.abstracts;


import com.project.basebeauty.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}

