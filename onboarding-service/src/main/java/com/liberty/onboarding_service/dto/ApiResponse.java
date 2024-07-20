package com.liberty.onboarding_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.liberty.onboarding_service.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse <T>{
    private String status;
    private String message;
    private T data;

    public ApiResponse(boolean success, T data, String message) {
        this.status = success ? "success" : "failure";
        this.message = message;
        this.data = data;
    }

    public ApiResponse(boolean success, String message) {
        this.status = success ? "success" : "failure";
        this.message = message;
        this.data = null;
    }
}
