package com.project.basebeauty.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Table(name = "customer")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerID;

    @Column(name = "customerEmail")
    private String customerEmail;

    @Column(name = "customerPassword")
    private String customerPassword;

    @Column(name = "customerFirstName")
    private String customerFirstName;

    @Column(name = "customertLastName")
    private String customertLastName;

    @Column(name = "customerPhoneNumber")
    private String customerPhoneNumber;

    @Column(name = "customerPackage")
    private String customerPackage;

    @Column(name = "customerSessionLeft")
    private int customerSessionLeft;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID &&
                Objects.equals(customerEmail, customer.customerEmail) &&
                Objects.equals(customerPassword, customer.customerPassword) &&
                Objects.equals(customerFirstName, customer.customerFirstName) &&
                Objects.equals(customertLastName, customer.customertLastName) &&
                Objects.equals(customerPhoneNumber, customer.customerPhoneNumber) &&
                Objects.equals(customerPackage, customer.customerPackage) &&
                Objects.equals(customerSessionLeft, customer.customerSessionLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, customerEmail, customerPassword, customerFirstName, customertLastName, customerPhoneNumber,customerPackage,customerSessionLeft);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customertLastName='" + customertLastName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerPackage='" + customerPackage + '\'' +
                ", customerSessionLeft='" + customerSessionLeft + '\'' +
                '}';
    }
}
