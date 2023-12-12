package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.UserRegistrationFormDto;
import com.ecommerce.backendAtHiit.dto.response.ApiResponse;
import com.ecommerce.backendAtHiit.model.UserRegistrationForm;
import com.ecommerce.backendAtHiit.repository.UserRegRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {
    @Autowired
    private UserRegRepository userRegRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserRegistrationFormDto userRegistrationFormDto){
        Optional<UserRegistrationForm> userEmail = userRegRepository.findByEmail(userRegistrationFormDto.getEmail());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Failed");

        if (userEmail.isPresent()){
            apiResponse.setMessage("Email already exist");
            return ResponseEntity.badRequest().body(apiResponse);
        }
        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
        userRegistrationForm.setFirstName(userRegistrationFormDto.getFirstName());
        userRegistrationForm.setLastName(userRegistrationFormDto.getLastName());
        userRegistrationForm.setPassword(userRegistrationFormDto.getPassword());
        userRegistrationForm.setEmail(userRegistrationFormDto.getEmail());
        apiResponse.setMessage("Login Successful...");
        apiResponse.setData(userRegistrationForm.toString());
        userRegRepository.save(userRegistrationForm);
        return ResponseEntity.ok().body(apiResponse);
    }
}