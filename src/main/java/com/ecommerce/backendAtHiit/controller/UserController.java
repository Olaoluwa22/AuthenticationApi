package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.UserDto;
import com.ecommerce.backendAtHiit.dto.UserResponseDto;
import com.ecommerce.backendAtHiit.dto.response.ApiResponse;
import com.ecommerce.backendAtHiit.model.User;
import com.ecommerce.backendAtHiit.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserResponseDto userResponseDto) throws SQLIntegrityConstraintViolationException {
        Optional<User> usersEmail = userRepository.findByEmail(userResponseDto.getEmail());
        if (usersEmail.isPresent()) {
            return ResponseEntity.badRequest().body("Email already Exist...");
        }
        User user = new User();
        user.setFirstname(userResponseDto.getFirstName());
        user.setLastname(userResponseDto.getLastName());
        user.setOtherName(userResponseDto.getOtherName());
        user.setPassword(userResponseDto.getPassword());
        user.setEmail(userResponseDto.getEmail());
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        user.setActive(userResponseDto.isActive());
        userRepository.save(user);
        return ResponseEntity.ok().body("Successfully Created...");
    }

     @GetMapping("/users")
     public Page<User> getUserByPageable(@RequestParam int page, @RequestParam int size){
       Pageable pageable = PageRequest.of(page,size);
        return userRepository.findAll(pageable);
     }
     @DeleteMapping("/user/{id}")
    public ResponseEntity<?> removeUser(@PathVariable Long id){
         ApiResponse<String> apiResponse = new ApiResponse<>();
         apiResponse.setMessage("Failed");
         try{
             Optional<User> usersId = userRepository.findById(id);
             if (usersId.isEmpty()){
                 apiResponse.setMessage("User does not exist");
                 return ResponseEntity.badRequest().body(apiResponse);
             }
             User user = usersId.get();
             apiResponse.setMessage("User Successfully Deleted...");
             user.setDeleted(true);
             user.setUpdatedAt(Instant.now());
             userRepository.save(user);
             return ResponseEntity.ok().body(apiResponse);

         }catch(Exception e){
             e.printStackTrace();
         }
         return ResponseEntity.internalServerError().body(apiResponse);
     }
     @GetMapping("/user/info")
    public ResponseEntity<?> getUsers(){
        ApiResponse<List<UserDto>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Failed");
        try{
            List<User> all = userRepository.findByDeleted(false);
            List<UserDto> responseData = new ArrayList<>();
            all.forEach(user-> {
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setFirstname(user.getFirstname());
                userDto.setLastname(user.getLastname());
                userDto.setOthername(user.getOtherName());
                userDto.setEmail(user.getEmail());
                userDto.setActive(user.isActive());
                userDto.setUpdatedAt(user.getUpdatedAt());
                userDto.setCreatedAt(user.getCreatedAt());
                responseData.add(userDto);
            });
            apiResponse.setMessage("Successful");
            apiResponse.setData(responseData);
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
         return ResponseEntity.internalServerError().body(apiResponse);
     }
}
