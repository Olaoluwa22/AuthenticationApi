package com.ecommerce.backendAtHiit.service;

import com.ecommerce.backendAtHiit.model.User;
import jakarta.servlet.http.HttpServletRequest;

public interface ExtendedSecurityService {
    User loggedInUser(HttpServletRequest request);
}
