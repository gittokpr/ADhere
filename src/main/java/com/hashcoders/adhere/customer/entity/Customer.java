package com.hashcoders.adhere.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class Customer {
    private Long id;
    private String name;
    private String mail;
    private String phoneNumber;
    private String address;
}
