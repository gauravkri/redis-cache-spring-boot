package com.gauravkri.rediscacheexample.config;

import com.gauravkri.rediscacheexample.entity.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
public class CustomKeyGenerate implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
       log.info(" {}",params[0]);
        CustomerEntity customerEntity = (CustomerEntity) params[0];
        return customerEntity.getId();
    }
}
