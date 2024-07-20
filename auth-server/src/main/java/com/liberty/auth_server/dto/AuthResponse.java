package com.liberty.auth_server.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String jwtToken;
}
