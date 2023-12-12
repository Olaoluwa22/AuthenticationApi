package com.ecommerce.backendAtHiit.service.serviceImpl;

import com.ecommerce.backendAtHiit.constant.AppConstant;
import com.ecommerce.backendAtHiit.dto.AuthenticationDto;
import com.ecommerce.backendAtHiit.dto.response.ApiResponse;
import com.ecommerce.backendAtHiit.model.User;
import com.ecommerce.backendAtHiit.repository.UserRepository;
import com.ecommerce.backendAtHiit.service.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> login(AuthenticationDto authenticationDto, HttpServletResponse response) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(AppConstant.FAILED.getMessage());
        Optional<User> userEmail = userRepository.findByEmail(authenticationDto.getEmail());
        try {
            if (userEmail.isEmpty()) {
                apiResponse.setMessage(AppConstant.FAILED.getMessage());
                return new ResponseEntity<>(apiResponse,HttpStatus.UNAUTHORIZED);
            }
            User user = userEmail.get();
            if (user.isDeleted()) {
                apiResponse.setMessage(AppConstant.FAILED.getMessage());
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(!authenticationDto.getPassword().equals(user.getPassword())){
                apiResponse.setMessage(AppConstant.UNAUTHORIZED.getMessage());
                return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
            }
            Cookie cookie = new Cookie("login", user.getEmail());
            response.addCookie(cookie);
            apiResponse.setMessage(AppConstant.SUCCESS.getMessage());
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(apiResponse,HttpStatus.UNAUTHORIZED);
    }
}
