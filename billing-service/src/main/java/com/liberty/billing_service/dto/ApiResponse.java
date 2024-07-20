package com.liberty.billing_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    private String status;
    private String message;
    private T data;

    public ApiResponse(boolean success, T data, String message) {
        this.status = success ? "success" : "error";
        this.data = data;
        this.message = message;
    }
}
