package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Customer;

public interface CustomerService {


     Customer registerCustomer(String email, String password, String fname, String lname, String tel);

     Customer authenticatecustomer(Customer customer);
}
