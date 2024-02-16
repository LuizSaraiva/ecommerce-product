package com.ecommerce.ecommerceproduct.domain.service.Impl;

import com.ecommerce.ecommerceproduct.domain.exception.ProductNotFoundException;
import com.ecommerce.ecommerceproduct.domain.model.Product;
import com.ecommerce.ecommerceproduct.domain.repository.ProductRepository;
import com.ecommerce.ecommerceproduct.domain.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElseThrow(() ->  new ProductNotFoundException(id));
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        log.info("Saving product.");
        return productRepository.save(product);
    }

    @Override
    public void updateStatusProduct(boolean status, UUID id) {
        Product product = getProductById(id);
        product.setStatus(status);
        saveProduct(product);
    }

}
