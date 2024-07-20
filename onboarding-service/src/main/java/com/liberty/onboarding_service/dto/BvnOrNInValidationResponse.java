package com.liberty.onboarding_service.dto;

import lombok.Data;

@Data
public class BvnOrNInValidationResponse {
    private String firstName;
    private String lastName;
    private String otherName;

    public BvnOrNInValidationResponse(String firstName, String lastName, String otherName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
    }
}
