package com.ecommerce.backendAtHiit.repository;

import com.ecommerce.backendAtHiit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByDeleted(boolean deleted);
    Optional<User> findByEmailAndDeleted(String email, boolean deleted);
}
