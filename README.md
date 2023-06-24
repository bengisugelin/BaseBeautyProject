# Base Beauty Project:
## CSIS3275---GroupProject
This is the repository of CSIS3275 Software Engineering course. 

Spring Boot MVC project Structure


```
── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── basebeauty
    │   │           └── basebeautyproject
    │   │               ├── controller / api / web
    │   │               │   └── CustomersController.java
    |   |               |   └── OrdersController.java
    │   │               ├── dao / repo
    │   │               │   ├── Concrete
    │   │               │   |    ├── 
    │   │               │   |    ├── 
    │   │               │   |    └── 
    │   │               │   ├── Abstract
    │   │               │   |    ├── CustomerDao.java
    |   |               |   |    └── OrderDao.java
    │   │               ├── model/entities
    │   │               │   ├── Concrete
    │   │               │   |    ├── Customer.java [customer_id(pk), customer_name, customer_surname, customer_tel, customer_mail, password, customer_age, customer_allergy, customer_concern ]
    │   │               │   |    ├── Expert.java [expert_id(pk), expert_name, expert_surname, expert_tel, expert_mail, expert_area, expert_state(available, not available) ]
    │   │               │   |    └── reservation.java [ expert_id(fk), customer_id(fk), reservation_id (pk), reservation_date, reservation_time, description ]
    │   │               │   ├── Abstract
    │   │               │   |    ├── 
    │   │               │   |    └── 
    │   │               └── service/business
    │   │               │   ├── Concrete
    │   │               │   |    ├── CustomerManager(implements customerService)
    │   │               │   |    ├── OrderManager(implements orderService)
    │   │               │   |    └── 
    │   │               │   ├── Abstract
    │   │               │   |    ├── CustomerService.java
    │   │               │   |    └── OrderService.java
    │   │               │   ├── Requests
    │   │               │   |    ├── CreateCustomerRequest.java
    │   │               │   ├── Responses
    │   │               │   |    ├── CreateCustomerResponse.jav
    │   ├── resources
    │   │   ├── Static
    │   │   │   ├── application.css
    │   │   │   
    │   │   ├── templates
    │   │   │   ├── Main.html
    │   └── webapp
    │       ├── WEB-INF
    │       │   ├── 
    │       │   ├── views
    │       │   │   ├── 
    │       │   │   │   ├── 
    │       │   │   │   ├── 
    │       │   │   │   ├── 
    │       │   │   │   └── 
    │       │   │   ├── 
    │       │   │   ├── 
    │       │   │   └── 
    │       │   └── web.xml
    │       ├── images
    │       └── styles
```

[Group8_Base-Beauty_PROGRESS-REPORT-1.pdf](https://github.com/bengisugelin/BaseBeautyProject/files/11855907/Group8_Base-Beauty_PROGRESS-REPORT-1.pdf)


