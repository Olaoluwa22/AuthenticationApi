package com.ecommerce.backendAtHiit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
@RequestMapping("/")
    public String homepage(){
      return "Welcome to Spring";
    }
    @PostMapping("/post")
    public void recieveDate(){
    
    }
    @RequestMapping("/loginpage/auth")
    public String authenticate(){
        return "Follow this link: https://validateuser.auth.io";
    }
}
