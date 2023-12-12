package com.ecommerce.backendAtHiit.service;

import com.ecommerce.backendAtHiit.dto.AuthenticationDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> login(AuthenticationDto authenticationDto, HttpServletResponse response);
}
