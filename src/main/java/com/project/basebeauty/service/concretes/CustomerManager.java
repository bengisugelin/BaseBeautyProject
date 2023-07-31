package com.project.basebeauty.service.concretes;

import com.project.basebeauty.dataAccess.abstracts.CustomerRepository;
import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.service.abstracts.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(String email, String password, String fname, String lname, String tel, String customerPackage, int customerSessionLeft) {
        if (email == null || password == null) {
            return null;
        } else {
            Customer newcustomer = new Customer();
            newcustomer.setCustomerEmail(email);
            newcustomer.setCustomerPassword(password);
            newcustomer.setCustomerFirstName(fname);
            newcustomer.setCustomertLastName(lname);
            newcustomer.setCustomerPhoneNumber(tel);
            newcustomer.setCustomerPackage(customerPackage);
            newcustomer.setCustomerSessionLeft(customerSessionLeft);
            return customerRepository.save(newcustomer);
        }
    }


    @Override
    public Customer authenticatecustomer(Customer customer) {
        return customerRepository.findByCustomerEmailAndCustomerPassword(customer.getCustomerEmail(), customer.getCustomerPassword()).orElse(null);
    }

    public Customer getCustomerById(Customer customer) {


        return customerRepository.findCustomerByCustomerEmail(customer.getCustomerEmail()).orElse(null);

    }

    @Override
    public Customer updatePackageInfo(Customer customer, String customerPackage, int customerSessionLeft) {

        customer.setCustomerPackage(customerPackage);
        customer.setCustomerSessionLeft(customerSessionLeft);
        return customerRepository.save(customer);

    }


}
