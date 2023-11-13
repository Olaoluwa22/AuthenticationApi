package com.ecommerce.backendAtHiit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
@RequestMapping("/")
    public String homepage(){
      return "Welcome to Spring";
    }
    @RequestMapping("/loginpage")
    public String loginPage(){
    return "Follow this link to login to your profile";
    }
    @RequestMapping("/loginpage/auth")
    public String authenticate(){
        return "Follow this link: https://authenticateUser.auth.io";
    }
}
