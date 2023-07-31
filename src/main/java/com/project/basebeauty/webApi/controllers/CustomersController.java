package com.project.basebeauty.webApi.controllers;

import com.project.basebeauty.dataAccess.abstracts.CustomerRepository;
import com.project.basebeauty.entities.concretes.Customer;
import com.project.basebeauty.service.abstracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
//    private CustomerService customerService;
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomersController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/register")
//    public String getRegisterPage(Model model) {
//        model.addAttribute("registerRequest", new Customer());
//        return "register_page";
//    }
//
//    @GetMapping("/login")
//    public String getLoginPage(ModelMap model) {
//        model.put("loginRequest", new Customer());
//        return "login_page";
//    }
//
//    @PostMapping("/register")
//    public String register(
//            @RequestParam("customerEmail") String customerEmail,
//            @RequestParam("customerPassword") String customerPassword,
//            @RequestParam("customerFirstName") String customerFirstName,
//            @RequestParam("customerLastName") String customerLastName,
//            @RequestParam("customerPhoneNumber") String customerPhoneNumber
//    ) {
//        System.out.println("register request: " + customerEmail);
//
//        Customer registeredCustomer = customerService.registerCustomer(
//                customerEmail,
//                customerPassword,
//                customerFirstName,
//                customerLastName,
//                customerPhoneNumber
//        );
//
//        return registeredCustomer == null ? "error_page" : "redirect:/login";
//    }
//
//    @PostMapping("/login")
//    public String login(
//            @RequestParam("customerEmail") String customerEmail,
//            @RequestParam("customerPassword") String customerPassword,
//            ModelMap model
//    ) {
//        System.out.println("login request: " + customerEmail);
//        Customer customer = new Customer();
//        customer.setCustomerEmail(customerEmail);
//        customer.setCustomerPassword(customerPassword);
//        Customer authenticated = customerService.authenticatecustomer(customer);
//
//        if (authenticated != null) {
//            model.put("customerLogin", authenticated.getCustomerEmail());
//            return "personal_page";
//        } else {
//            return "error_page";
//        }
//    }
private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Customer());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(ModelMap model) {
        model.put("loginRequest", new Customer());
        return "login_page";
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(
//            @RequestParam("customerEmail") String customerEmail,
//            @RequestParam("customerPassword") String customerPassword,
//            @RequestParam("customerFirstName") String customerFirstName,
//            @RequestParam("customerLastName") String customerLastName,
//            @RequestParam("customerPhoneNumber") String customerPhoneNumber
//    ) {
//        System.out.println("register request: " + customerEmail);
//
//        Customer registeredCustomer = customerService.registerCustomer(
//                customerEmail,
//                customerPassword,
//                customerFirstName,
//                customerLastName,
//                customerPhoneNumber
//        );
//
//        if (registeredCustomer != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(
//            @RequestParam("customerEmail") String customerEmail,
//            @RequestParam("customerPassword") String customerPassword,
//            ModelMap model
//    ) {
//        System.out.println("login request: " + customerEmail);
//        Customer customer = new Customer();
//        customer.setCustomerEmail(customerEmail);
//        customer.setCustomerPassword(customerPassword);
//        Customer authenticated = customerService.authenticatecustomer(customer);
//
//        if (authenticated != null) {
//            model.put("customerLogin", authenticated.getCustomerEmail());
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
@PostMapping("/register")
public ResponseEntity<String> register(
        @RequestParam("customerEmail") String customerEmail,
        @RequestParam("customerPassword") String customerPassword,
        @RequestParam("customerFirstName") String customerFirstName,
        @RequestParam("customerLastName") String customerLastName,
        @RequestParam("customerPhoneNumber") String customerPhoneNumber,
        @RequestParam("customerPackage") String customerPackage

) {
    System.out.println("register request: " + customerEmail);

    int customerSessionLeft = 0;
    if(customerPackage.equals("premium")){
        customerSessionLeft +=20;
    }else if (customerPackage.equals("gold")){
        customerSessionLeft += 15;
    }else if(customerPackage.equals("bronze")){
        customerSessionLeft += 10;
    } else if (customerPackage.equals("basic")) {
        customerSessionLeft += 5;

    }

    Customer registeredCustomer = customerService.registerCustomer(
            customerEmail,
            customerPassword,
            customerFirstName,
            customerLastName,
            customerPhoneNumber,
            customerPackage,
            customerSessionLeft
    );

    if (registeredCustomer != null) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam("customerEmail") String customerEmail,
            @RequestParam("customerPassword") String customerPassword,
            ModelMap model
    ) {
        System.out.println("login request: " + customerEmail);
        Customer customer = new Customer();
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerPassword(customerPassword);
        Customer authenticated = customerService.authenticatecustomer(customer);

        if (authenticated != null) {
            model.put("customerLogin", authenticated.getCustomerEmail());
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
