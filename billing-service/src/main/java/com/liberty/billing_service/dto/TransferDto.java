package com.liberty.billing_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {
   private String customerAccountId;
    private BigDecimal amount;
}
