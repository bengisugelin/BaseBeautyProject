package com.project.basebeauty.entities.concretes;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.util.Date;

@Table(name = "reservation")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id")
    private Expert expert;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(name = "expertServiceArea")
    private String expertServiceArea;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "reservation_time")
    private Time reservationTime;

    @Column(name = "description")
    private String description;


}
