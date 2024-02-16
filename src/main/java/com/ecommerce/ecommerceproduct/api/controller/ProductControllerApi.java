package com.ecommerce.ecommerceproduct.api.controller;


import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductDisableRequest;
import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


public interface ProductControllerApi {

    @GetMapping
    ResponseEntity<?> getAllProducts();

    @GetMapping("/{id}")
    ResponseEntity<?> getProductById(@PathVariable("id") UUID id);

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody(required = true) @Valid ProductRequest productRequest);

    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@RequestBody(required = true) @Valid ProductRequest productRequest,
                                    @PathVariable("id") UUID id);

    @PatchMapping("/{id}")
    ResponseEntity<?> disableProduct(@RequestBody(required = true) ProductDisableRequest productDisableRequest,
                                     @PathVariable("id") UUID id);

}
