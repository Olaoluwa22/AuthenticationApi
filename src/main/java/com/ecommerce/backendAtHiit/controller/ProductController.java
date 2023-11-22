package com.ecommerce.backendAtHiit.controller;

import com.ecommerce.backendAtHiit.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    List<ProductDto> products = new ArrayList<>();
    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto productDto){
        products.add(productDto);
        return ResponseEntity.badRequest().body("Input Error");
    }
    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return products;
    }
}
