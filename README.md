# Base Beauty Project:
## CSIS3275---GroupProject
This is the repository of CSIS3275 Software Engineering course. 

Spring Boot MVC project Structure

![image](https://github.com/bengisugelin/CSIS3275---GroupProject/assets/113550043/2021b1fd-9280-4045-907f-799c3552a2f5)

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

