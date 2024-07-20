package com.liberty.onboarding_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bvn;
    private String nin;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String accountBalance;
    private String userName;
    private String password;
    private String pin;
    private String customerId;
}
