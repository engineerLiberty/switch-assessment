package com.liberty.billing_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String bvn;
    private String nin;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private BigDecimal accountBalance;
    private String address;
    private String userName;
    private String password;
    private String pin;
    private String customerId;
}
