package com.hashcoders.adhere.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    private Long id;
}
