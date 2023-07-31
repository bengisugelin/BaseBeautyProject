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
    public Customer registerCustomer(String email, String password, String fname, String lname, String tel, String packageName, int sessionLeft) {
        if(email == null || password == null){
            return null;
        }else{
            Customer newcustomer = new Customer();
            newcustomer.setCustomerEmail(email);
            newcustomer.setCustomerPassword(password);
            newcustomer.setCustomerFirstName(fname);
            newcustomer.setCustomertLastName(lname);
            newcustomer.setCustomerPhoneNumber(tel);
            newcustomer.setCustomerPackage(packageName);
            newcustomer.setCustomerSessionLeft(sessionLeft);
            return customerRepository.save(newcustomer);
        }
    }

    @Override
    public Customer authenticatecustomer(Customer customer) {
        return customerRepository.findByCustomerEmailAndCustomerPassword(customer.getCustomerEmail(),customer.getCustomerPassword()).orElse(null);
    }

//    public Customer int decreaseSessionNumber(Customer customer){
//
//    }
}
