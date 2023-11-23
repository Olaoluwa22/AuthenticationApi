package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.ProductDto;
import com.ecommerce.backendAtHiit.model.Product;
import com.ecommerce.backendAtHiit.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setCreatedAt(productDto.getCreatedAt());
        product.setUpdatedAt(productDto.getUpdatedAt());
        product.setActive(productDto.isActive());
        productRepository.save(product);
        return ResponseEntity.badRequest().body("Input Error");
    }
    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        List<Product> allProduct = productRepository.findAll();
        return new ResponseEntity<>(allProduct, HttpStatus.CREATED);
    }
}
