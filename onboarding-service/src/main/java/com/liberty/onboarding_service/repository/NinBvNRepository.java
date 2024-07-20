package com.liberty.onboarding_service.repository;

import com.liberty.onboarding_service.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This repository is a miniature of  data bank for nin and bvn
 */
@Repository
public class NinBvNRepository {
    private final Map<String, Customer> bvnToCustomerMap;
    private final Map<String, Customer> ninToCustomerMap;

     public NinBvNRepository() {
        bvnToCustomerMap = new HashMap<>();
        ninToCustomerMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setBvn("43345678901");
        customer1.setNin("A123456789");
        customer1.setFirstName("Switch");
        customer1.setLastName("Assessment");
        customer1.setMiddleName("Test");

        Customer customer2 = new Customer();
        customer2.setBvn("22256784712");
        customer2.setFirstName("Switch");
        customer2.setLastName("Assessment");
        customer2.setMiddleName("Test");

        bvnToCustomerMap.put(customer1.getBvn(), customer1);
        bvnToCustomerMap.put(customer2.getBvn(),customer2);

        ninToCustomerMap.put(customer1.getNin(), customer1);
        ninToCustomerMap.put(customer2.getNin(), customer2);

    }

    public Optional<Customer> findByBvn(String bvn) {
        return Optional.ofNullable(bvnToCustomerMap.get(bvn));
    }

    public Optional<Customer> findByNin(String nin) {
        return Optional.ofNullable(ninToCustomerMap.get(nin));
    }
}
