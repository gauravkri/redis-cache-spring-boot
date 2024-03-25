package com.gauravkri.rediscacheexample.service;

import com.gauravkri.rediscacheexample.entity.CustomerEntity;
import com.gauravkri.rediscacheexample.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Override
    @Cacheable(value = "customer", key = "#id")
    public CustomerEntity getCustomerById(String id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepo.findById(id);
        return customerEntityOptional.orElse(null);
    }

    @Override
    @Caching(
            evict = {@CacheEvict(value = "CustomerList", allEntries = true)}
    )
    public CustomerEntity saveCustomer(CustomerEntity customerEntity){
        CustomerEntity customerEntity1 =customerRepo.save(customerEntity);
        log.info(customerEntity1.toString());
        return customerEntity1;
    }

    @Override
//    @CachePut(value = "customer", key = "#id")
    @Caching(
            evict = {@CacheEvict(value = "CustomerList", allEntries = true)},
            put = {@CachePut(value = "customer", key = "#id")}
    )
    public CustomerEntity editCustomer(CustomerEntity customerEntity, String id) {
        customerEntity.setId(id);
        return customerRepo.save(customerEntity);
    }

    @Override
    @CacheEvict(cacheNames = "customer", key = "#id", beforeInvocation = true)
    public String deleteCustomerById(String id) {
        try {
            customerRepo.deleteById(id);
        }catch (Exception e){
            return "Unable to delete";
        }
        return "Delete successfully";
    }


    @Cacheable(value = "CustomerList")
    public List<CustomerEntity> getAllCustomer(){
        return customerRepo.findAll();
    }


}
