package com.ecommerce.backendAtHiit.exception.handler;

public class UserAuthenticationException extends RuntimeException {
    public UserAuthenticationException(String message) {
        super(message);
    }
}
