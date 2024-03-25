package com.gauravkri.rediscacheexample.repo;

import com.gauravkri.rediscacheexample.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<CustomerEntity,String> {
}
