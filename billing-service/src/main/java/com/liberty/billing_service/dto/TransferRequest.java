package com.liberty.billing_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private BigDecimal amount;
    private String recipientAccount;
}
