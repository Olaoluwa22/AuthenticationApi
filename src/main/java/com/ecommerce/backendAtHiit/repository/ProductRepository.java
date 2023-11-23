package com.ecommerce.backendAtHiit.repository;

import com.ecommerce.backendAtHiit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
