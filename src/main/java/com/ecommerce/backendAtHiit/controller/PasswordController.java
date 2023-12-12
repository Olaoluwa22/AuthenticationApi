package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.AuthenticationDto;
import com.ecommerce.backendAtHiit.dto.PasswordRequestDto;
import com.ecommerce.backendAtHiit.service.PasswordService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @PostMapping("/update-password")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody PasswordRequestDto passwordRequestDto, HttpServletRequest request){
        return  passwordService.updatePassword(passwordRequestDto, request);
    }
}
