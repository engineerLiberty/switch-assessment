package com.liberty.onboarding_service.service;

import com.liberty.onboarding_service.dto.ApiResponse;
import com.liberty.onboarding_service.dto.BvnOrNInValidationRequest;
import com.liberty.onboarding_service.dto.BvnOrNInValidationResponse;
import com.liberty.onboarding_service.model.Customer;

public interface CustomerService {
    Customer onboardCustomer(Customer customer);

    ApiResponse<BvnOrNInValidationResponse> validateCustomerBvnOrNIN(BvnOrNInValidationRequest bvnOrNInValidationRequest);
    ApiResponse<Customer> getDashBoardDetails(String customerId);
}
