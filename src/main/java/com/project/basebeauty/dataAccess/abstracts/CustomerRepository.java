package com.project.basebeauty.dataAccess.abstracts;

import com.project.basebeauty.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerEmailAndCustomerPassword(String email, String password);
    Optional<Customer> findCustomerByCustomerEmail(String customerEmail);

}
