package com.liberty.api_gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "auth-server")
public interface AuthClient {

    @GetMapping("/auth/validate")
    Boolean validateToken(@RequestParam("token") String token);
}
