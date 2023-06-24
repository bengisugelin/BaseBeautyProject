package com.project.basebeauty.entities.concretes;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "experts")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expert_id")
    private int expertID;

    @Column(name = "expertPassword")
    private String expertPassword;

    @Column(name = "expertFirstName")
    private String expertFirstName;

    @Column(name = "expertLastName")
    private String expertLastName;

    @Column(name = "expertPhoneNumber")
    private String expertPhoneNumber;

    @Column(name = "expertEMail")
    private String expertEMail;

    @Column(name = "expertServiceArea")
    private String expertServiceArea; //makeup-skincare etc

    @Column(name = "expertState")
    private boolean expertState; //available (1), not-available(0)

    @Column(name = "expertDescription")
    private String expertDescription;

    }
