package com.liberty.billing_service.controller;

import com.liberty.billing_service.dto.ApiResponse;
import com.liberty.billing_service.dto.TransferDto;
import com.liberty.billing_service.dto.TransferRequest;
import com.liberty.billing_service.model.*;
import com.liberty.billing_service.repository.TransferRepository;
import com.liberty.billing_service.service.BillingService;
import com.liberty.billing_service.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/billing")
public class BillController {
    private final BillingService billingService;
    private final TransferService transferService;

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Payment> postBill(@RequestBody Payment payment) {
        return ResponseEntity.ok(billingService.submitPayment(payment));
    }
    @PostMapping("transfer/{clientId}")
    public ApiResponse<?> transferFunds(@PathVariable String clientId, @RequestBody TransferRequest transferRequest) {
        return transferService.transferFunds(clientId, transferRequest);
    }

    @GetMapping("/getBillers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Biller>> getBillers(Long categoryId) {
        return ResponseEntity.ok(billingService.getBillers(categoryId));
    }

    @GetMapping("/getProduct")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> getProducts(Long categoryId) {
        return ResponseEntity.ok(billingService.getProducts(categoryId));
    }

     @GetMapping("/getCategories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BillCategory>> getCategories() {
        return ResponseEntity.ok(billingService.getCategories());
    }
    @GetMapping("/bankList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Bank>> getBank() {
        return ResponseEntity.ok(billingService.getBank());
    }
}