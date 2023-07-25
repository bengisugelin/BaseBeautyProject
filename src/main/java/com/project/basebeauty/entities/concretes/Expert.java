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


    @Column(name = "expertPassword")
    private String expertPassword;


    @Column(name = "expert_id")
    private Long expertId;



    @Column(name = "expert_first_name")
    private String expertFirstName;

    @Column(name = "expert_last_name")
    private String expertLastName;


    @Column(name = "expertPhoneNumber")
    private String expertPhoneNumber;

    @Column(name = "expertEMail")
    private String expertEMail;

    @Column(name = "expert_service_area")
    private String expertServiceArea; // makeup, hair-styling, skincare, nail, others



    /*

    @Column(name = "expert_id")
    private int expertID;

    @Column(name = "expertServiceArea")
    private String expertServiceArea; //makeup-skincare etc

    @Column(name = "expertFirstName")
    private String expertFirstName;

    @Column(name = "expertLastName")
    private String expertLastName;
*/


    @Column(name = "expertState")
    private boolean expertState; //available (1), not-available(0)

    @Column(name = "expertDescription")
    private String expertDescription;

    @Column(name = "expertImageFilename")
    private String expertImageFilename;

    public Long getExpertId() {
        return expertId;
    }



    // Setter method for expertImageFilename
    public void setExpertImageFilename(String expertImageFilename) {
        this.expertImageFilename = expertImageFilename;
    }
    }
