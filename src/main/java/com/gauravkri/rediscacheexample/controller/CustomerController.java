package com.gauravkri.rediscacheexample.controller;


import com.gauravkri.rediscacheexample.entity.CustomerEntity;
import com.gauravkri.rediscacheexample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public CustomerEntity getCustomerByid(@PathVariable String id){
        return customerService.getCustomerById(id);
    }


    @PostMapping("/customer/")
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity customerEntity){
        return customerService.saveCustomer(customerEntity);
    }

    @PutMapping("/customer/{id}")
    public CustomerEntity editCustomer(@RequestBody CustomerEntity customerEntity, @PathVariable String id){
       if (!id.isEmpty())
            return customerService.editCustomer(customerEntity,id);
        return null;
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable String id){
        if (!id.isEmpty())
            return customerService.deleteCustomerById(id);
        return "Id is null";
    }

    @GetMapping("/customer/")
    public List<CustomerEntity> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
