package com.ecommerce.ecommerceproduct.api.mapper.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class ProductResponse {

    private UUID id;
    private String description;
    private Boolean status;
    private String package_sale;

    private Timestamp created_at;
}
