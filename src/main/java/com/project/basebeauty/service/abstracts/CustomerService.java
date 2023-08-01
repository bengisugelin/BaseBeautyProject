package com.project.basebeauty.service.abstracts;

import com.project.basebeauty.entities.concretes.Customer;

public interface CustomerService {


     Customer registerCustomer(String email, String password, String fname, String lname, String tel, String customerPackage, int customerSessionLeft);

     Customer authenticatecustomer(Customer customer);
      Customer getCustomerById(Customer customer );
    Customer updatePackageInfo(Customer customer, String customerPackage, int customerSessionLeft);
}
