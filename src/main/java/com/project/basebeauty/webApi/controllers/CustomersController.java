package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.dataAccess.abstracts.CustomerRepository;
import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.service.abstracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
@RequestMapping()
public class CustomersController {


    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Customer());
        return "register_page";
    }

//    @GetMapping("/register")
//    public String getRegisterPage() {
////        model.put("registerRequest", new Customer());
//        return "register_page";
//    }

    @GetMapping("/login")
    public String getLoginPage(ModelMap model){
        model.put("loginRequest", new Customer());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Customer customer){
        System.out.println("register request: " + customer );

        Customer registeredCustomer = customerService
                .registerCustomer(customer.getCustomerEmail(),
                        customer.getCustomerPassword(),
                        customer.getCustomerFirstName(),
                        customer.getCustomertLastName(),
                        customer.getCustomerPhoneNumber());

        return registeredCustomer == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Customer customer, ModelMap model){
        System.out.println("login request: " + customer );
        Customer authenticated = customerService.authenticatecustomer(customer);

        if (authenticated != null){
            model.put("customerLogin", authenticated.getCustomerEmail());
            return "personal_page";
        }else{
            return "error_page";
        }

    }

}
