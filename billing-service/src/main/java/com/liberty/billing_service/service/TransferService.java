package com.liberty.billing_service.service;

import com.liberty.billing_service.apiClient.CustomerClient;
import com.liberty.billing_service.dto.ApiResponse;
import com.liberty.billing_service.dto.TransferRequest;
import com.liberty.billing_service.model.Customer;
import com.liberty.billing_service.model.Transfer;
import com.liberty.billing_service.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class TransferService {
    private final CustomerClient customerClient;

    private final TransferRepository transferRepository;

    @Transactional
    public ApiResponse<?> transferFunds(String clientId, TransferRequest transferRequest) {
        // Fetch customer details from onboarding service
        Customer customer = customerClient.getCustomerById(clientId);

        // Validate customer details
        if (customer == null) {
            return new ApiResponse<>(false, null, "Customer not found");
        }

        // Validate balance
        if (customer.getAccountBalance().compareTo(transferRequest.getAmount()) < 0) {
            return new ApiResponse<>(false, null, "Insufficient funds");
        }

        // Debit customer's account
        customer.setAccountBalance(customer.getAccountBalance().subtract(transferRequest.getAmount()));

        // Save the transfer details
        Transfer transfer = Transfer.builder()
                .clientId(clientId)
                .amount(transferRequest.getAmount())
                .recipientAccount(transferRequest.getRecipientAccount())
                .build();

        transferRepository.save(transfer);

        // Update customer account (assuming there's an endpoint to update customer)
        // customerClient.updateCustomer(customer);
        return new ApiResponse<>(true, transfer, "Transfer successful");
    }
}
