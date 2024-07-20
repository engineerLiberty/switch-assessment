package com.liberty.onboarding_service.dto;

import lombok.Data;

@Data
public class BvnOrNInValidationRequest {
    private String bvn;
    private String nin;
}
