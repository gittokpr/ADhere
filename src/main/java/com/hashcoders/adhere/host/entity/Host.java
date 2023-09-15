package com.hashcoders.adhere.host.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "host")
@Data
public class Host {
    private Long id;
    private String name;
    private String mail;
    private String phoneNumber;
    private String address;
}
