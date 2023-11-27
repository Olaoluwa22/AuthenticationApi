package com.ecommerce.backendAtHiit.repository;

import com.ecommerce.backendAtHiit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
