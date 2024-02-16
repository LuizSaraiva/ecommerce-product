package com.ecommerce.ecommerceproduct.api.mapper.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductEventDto {

    private UUID id;
    private String description;
    private boolean status;
    private String package_sale;
    private String actionType;
}
