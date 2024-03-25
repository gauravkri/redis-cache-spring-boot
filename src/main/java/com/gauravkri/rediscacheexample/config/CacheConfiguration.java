package com.gauravkri.rediscacheexample.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Slf4j
@Configuration
public class CacheConfiguration implements CachingConfigurer {

    @Autowired
    CustomKeyGenerate customKeyGenerate;
    @Bean("customKeyGenerator")
    public KeyGenerator keyGenerator() {
        return customKeyGenerate;
    }
}
