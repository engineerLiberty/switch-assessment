package com.liberty.onboarding_service.controller;

import com.liberty.onboarding_service.dto.ApiResponse;
import com.liberty.onboarding_service.dto.BvnOrNInValidationRequest;
import com.liberty.onboarding_service.model.Customer;
import com.liberty.onboarding_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/onboard")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer onboardedCustomer = customerService.onboardCustomer(customer);
        return ResponseEntity.ok(onboardedCustomer);
    }

    @GetMapping("/validateBvnOrNIN")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> validateCustomerBvnOrNIN(@RequestBody BvnOrNInValidationRequest bvnOrNin) {
        return customerService.validateCustomerBvnOrNIN(bvnOrNin);
    }

    @GetMapping("/customerDetails/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> getCustomerDetails(@PathVariable("customerId") String customerId) {
        return customerService.getDashBoardDetails(customerId);
    }

}
