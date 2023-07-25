package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Customer;

public interface CustomerService {


     Customer registerCustomer(String email, String password, String fname, String lname, String tel, String packageName, int sessionLeft);

     Customer authenticatecustomer(Customer customer);
}
