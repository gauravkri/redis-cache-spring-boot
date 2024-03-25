package com.gauravkri.rediscacheexample.service;

import com.gauravkri.rediscacheexample.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    CustomerEntity getCustomerById(String id);

    public CustomerEntity saveCustomer(CustomerEntity customerEntity);

    public CustomerEntity editCustomer(CustomerEntity customerEntity,String id);
    public String deleteCustomerById(String id);


    public List<CustomerEntity> getAllCustomer();
}
