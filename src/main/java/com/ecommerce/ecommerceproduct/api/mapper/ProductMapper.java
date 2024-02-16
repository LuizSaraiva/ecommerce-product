package com.ecommerce.ecommerceproduct.api.mapper;

import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductRequest;
import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductResponse;
import com.ecommerce.ecommerceproduct.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductRequest productDomainToDto(Product productDomain);
    Product productDtoToDomain(ProductRequest productRequest);

    ProductResponse productDomainToResponseDto(Product product);

    List<ProductRequest> listProductDomainToDto(List<Product> products);
    List<Product> listProductDtoToDomain(List<ProductRequest> productRequests);

    List<ProductResponse> listProductDomainToResponseDto(List<Product> products);

}
