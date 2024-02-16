package com.ecommerce.ecommerceproduct.api.mapper.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull
    @NotBlank
    private String description;

    private boolean status;
    @NotNull
    @NotBlank
    private String package_sale;
}
