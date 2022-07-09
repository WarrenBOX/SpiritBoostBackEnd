package com.spiritboost.spiritboost.Controller;


import com.spiritboost.spiritboost.Entity.Customer;
import com.spiritboost.spiritboost.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/SpiritBoost/api/v1/customer") //basic url， 请求的目标地址
public class Controller {
    private final ServiceImpl service;

    @Autowired
    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/all")
    public List<Customer> getCustomer() {return service.getUserList();}

    @PostMapping(path = "/add")
    public void postCustomer(@RequestBody Customer customer) {
        service.saveUser(customer);
    }
                                            // getmapping后面的path 是加在requestmapping后面
    @GetMapping(path = "/find/{customerId}")   //怎么做到把对象变成json format的?
    public Optional<Customer> getCustomerById(@PathVariable("customerId") Long id) {
        return service.getUserById(id);
    }

    @PutMapping(path = "/update/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long id,
//                               @RequestBody(required = false) String name,
//                               @RequestBody(required = false) String password   //@和requestbody不同
                               @RequestBody Customer customer

    ){
        service.updateCustomer(id,customer);
//        //search database for a customer with specific id
//        Optional<Customer> customer = service.getUserById(id);
//        if (customer == null) {
//            try {System.out.println(customer);
//                System.out.println("not found");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            //
//        }
    }

    @DeleteMapping(path = "/delete/{customerId}")
    public void deleteCustomer(@PathVariable("customerId")Long id){
        service.deteleCustomer(id);
    }
}
