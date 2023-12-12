package com.ecommerce.backendAtHiit.service.serviceImpl;

import com.ecommerce.backendAtHiit.constant.AppConstant;
import com.ecommerce.backendAtHiit.dto.PasswordRequestDto;
import com.ecommerce.backendAtHiit.dto.response.ApiResponse;
import com.ecommerce.backendAtHiit.model.User;
import com.ecommerce.backendAtHiit.repository.UserRepository;
import com.ecommerce.backendAtHiit.service.PasswordService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> updatePassword(@RequestBody PasswordRequestDto passwordRequestDto, HttpServletRequest request){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(AppConstant.FAILED.getMessage());
        Optional<User> email = userRepository.findByEmail(passwordRequestDto.getEmail());
        try{
           if (email.isEmpty()) {
                apiResponse.setMessage(AppConstant.FAILED.getMessage());
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
           }
            User user = email.get();
           if(!passwordRequestDto.getOldPassword().equals(user.getPassword())){
               apiResponse.setMessage(AppConstant.INCORRECT.getMessage());
               return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
           }
           if (!passwordRequestDto.getNewPassword().equals(passwordRequestDto.getConfirmNewPassword())){
               apiResponse.setMessage(AppConstant.INCORRECT.getMessage());
               return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }




        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }

}
