package com.liberty.billing_service.service;

import com.liberty.billing_service.dto.TransferDto;
import com.liberty.billing_service.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public interface BillingService {
     List<Biller> getBillers(Long categoryId);

     List<Product> getProducts(Long categoryId);
     TransferDto transfers(TransferDto transferDto);
     Payment submitPayment(Payment payment);
     List<BillCategory> getCategories();
      List<Bank> getBank();

}
