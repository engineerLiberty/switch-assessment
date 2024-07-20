package com.liberty.billing_service.controller;

import com.liberty.billing_service.dto.TransferDto;
import com.liberty.billing_service.model.BillCategory;
import com.liberty.billing_service.model.Biller;
import com.liberty.billing_service.model.Payment;
import com.liberty.billing_service.model.Product;
import com.liberty.billing_service.service.BillingService;
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

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Payment> postBill(@RequestBody Payment payment) {
        return ResponseEntity.ok(billingService.submitPayment(payment));
    }
    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<TransferDto> transfers(TransferDto transferDto) {
        return ResponseEntity.ok(billingService.transfers(transferDto));
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
}
