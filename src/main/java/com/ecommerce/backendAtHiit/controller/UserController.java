package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.UserDto;
import com.ecommerce.backendAtHiit.model.User;
import com.ecommerce.backendAtHiit.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto){
        User user = new User();
        user.setFirstname(userDto.getFirstName());
        user.setLastname(userDto.getLastName());
        user.setOtherName(userDto.getOtherName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        user.setActive(userDto.isActive());
        userRepository.save(user);
        return ResponseEntity.ok().body("Successfully Created...");
    }

     @GetMapping("/users")
     public Page<User> getUserByPageable(@RequestParam int page, @RequestParam int size){
       Pageable pageable = PageRequest.of(page,size);
        return userRepository.findAll(pageable);
     }
}
