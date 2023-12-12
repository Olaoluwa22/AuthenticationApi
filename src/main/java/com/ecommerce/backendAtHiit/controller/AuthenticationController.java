package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.AuthenticationDto;
import com.ecommerce.backendAtHiit.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationDto authenticationDto, HttpServletResponse response) {
        return authenticationService.login(authenticationDto, response);
    }
}
