package com.liberty.billing_service.service.impl;

import com.liberty.billing_service.dto.TransferDto;
import com.liberty.billing_service.model.*;
import com.liberty.billing_service.repository.BillingRepository;
import com.liberty.billing_service.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    @Override
    public List<Biller> getBillers(Long categoryId) {
        return billingRepository.getBillers(categoryId);
    }

    @Override
    public List<Product> getProducts(Long categoryId) {
        return billingRepository.getProducts(categoryId);
    }

    @Override
    public TransferDto transfers(TransferDto transferDto) {

        return null;
    }

    @Override
    public Payment submitPayment(Payment payment) {

        return billingRepository.submitPayment(payment);
    }

    @Override
    public List<BillCategory> getCategories() {
        return billingRepository.getCategories();
    }

    @Override
    public List<Bank> getBank() {
        return billingRepository.getBanks();
    }
}
