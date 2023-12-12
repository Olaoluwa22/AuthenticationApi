package com.ecommerce.backendAtHiit.service.serviceImpl;

import com.ecommerce.backendAtHiit.exception.handler.UserAuthenticationException;
import com.ecommerce.backendAtHiit.model.User;
import com.ecommerce.backendAtHiit.repository.UserRepository;
import com.ecommerce.backendAtHiit.service.ExtendedSecurityService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ExtendedSecurityServiceImpl implements ExtendedSecurityService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User loggedInUser(HttpServletRequest request) throws UserAuthenticationException {
        Cookie[] cookies = request.getCookies();
        boolean loggedIn= false;
        Cookie loginCookie = null;
        if (cookies == null){
            throw new UserAuthenticationException("UNAUTHORIZED");
        }
        for (int i = 0; i <cookies.length ; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("login")){
                loggedIn=true;
                loginCookie= cookie;
            }
        }
        if (!loggedIn){
            throw new UserAuthenticationException("UNAUTHORIZED");
        }
        Optional<User> cookieOwner = userRepository.findByEmailAndDeleted(loginCookie.getValue(), false);
        if (cookieOwner.isEmpty()){
            throw new UserAuthenticationException("UNAUTHORIZED");
        }
        return cookieOwner.get();
    }
}
