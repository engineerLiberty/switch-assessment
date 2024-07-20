package com.liberty.onboarding_service.repository;

import com.liberty.onboarding_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer>findByCustomerId(String customerId);

}
