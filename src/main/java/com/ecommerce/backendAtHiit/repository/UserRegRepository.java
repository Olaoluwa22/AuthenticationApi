package com.ecommerce.backendAtHiit.repository;

import com.ecommerce.backendAtHiit.model.UserRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRegRepository extends JpaRepository<UserRegistrationForm, Long> {
    Optional<UserRegistrationForm> findByEmail(String email);
}
