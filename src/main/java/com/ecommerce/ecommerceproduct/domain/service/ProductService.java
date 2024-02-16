package com.ecommerce.ecommerceproduct.domain.service;


import com.ecommerce.ecommerceproduct.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(UUID id);
    Product saveProduct(Product product);
    void updateStatusProduct(boolean status, UUID id);

    Product updateProduct(Product product);

}
