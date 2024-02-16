package com.ecommerce.ecommerceproduct.domain.exception;

import java.util.UUID;

public class ProductNotFoundException extends BusinessException {

    private static final String PRODUCT_NOT_FOUND = "Product id %s not found!";
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(UUID id){
        this(String.format(PRODUCT_NOT_FOUND,id.toString()));
    }
}
