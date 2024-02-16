package com.ecommerce.ecommerceproduct.domain.repository;

import com.ecommerce.ecommerceproduct.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product,UUID> {

}
