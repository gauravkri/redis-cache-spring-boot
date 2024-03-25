package com.gauravkri.rediscacheexample.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@ToString
@Document("customer")
public class CustomerEntity implements Serializable {

    @Id
    String id;

    String name;

    String age;
}
