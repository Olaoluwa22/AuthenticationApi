package com.ecommerce.backendAtHiit.service;

import com.ecommerce.backendAtHiit.dto.PasswordRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface PasswordService{
    ResponseEntity<?> updatePassword(@RequestBody PasswordRequestDto passwordRequestDto, HttpServletRequest request);
}