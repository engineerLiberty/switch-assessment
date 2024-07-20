package com.liberty.billing_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    private Long id;
    private BigDecimal amount;
    private Long productId;
    private String customerAccountId;
}
