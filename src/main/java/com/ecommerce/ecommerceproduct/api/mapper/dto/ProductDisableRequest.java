package com.ecommerce.ecommerceproduct.api.mapper.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductDisableRequest {

    @NotBlank
    @NotNull
    private boolean status;


}
