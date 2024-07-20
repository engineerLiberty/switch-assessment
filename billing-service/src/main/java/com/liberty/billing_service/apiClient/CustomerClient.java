package com.liberty.billing_service.apiClient;

import com.liberty.billing_service.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CustomerClient {
    @GetMapping("/customerDetails/{customerId}")
    Customer getCustomerById(@PathVariable("clientId") String clientId);
}
